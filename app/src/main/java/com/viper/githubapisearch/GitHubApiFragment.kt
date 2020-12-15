package com.viper.githubapisearch

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_git_hub_api.*
import org.koin.android.viewmodel.ext.android.viewModel


class GitHubApiFragment : Fragment() {

    private val viewModel: GitHubViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_git_hub_api, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.menu_github_search, menu)
        val menuItem = menu.findItem(R.id.app_bar_search)
        val actionView = menuItem.actionView as SearchView
        actionView.queryHint = "Search GitHub Repo Here"
        rv_github_search.layoutManager = LinearLayoutManager(this.requireContext())
        rv_github_search.setHasFixedSize(false)
        rv_github_search.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL))

        actionView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //TODO:Handle if the user submits the query

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.getRepository().observe(viewLifecycleOwner, Observer { t ->

                    val searchResults = GitHubApiRequest()

                    t.forEach { c ->
                        newText?.let {
                            if (c.name.contains(it, true)) {
                                searchResults.add(c)
                            }
                        }
                    }

                    val adapter = GitHubApiRecyclerViewAdapter(requireContext())
                    adapter.gitHubApiRequest = searchResults
                    rv_github_search.adapter = adapter
                    adapter.notifyDataSetChanged()

                })
                return true
            }

        })

        return super.onCreateOptionsMenu(menu, inflater)
    }

}