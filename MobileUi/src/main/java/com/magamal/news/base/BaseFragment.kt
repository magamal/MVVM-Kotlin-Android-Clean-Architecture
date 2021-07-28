package com.magamal.news.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.news.presentation.base.BaseViewModel

/**
 * @author Mahmoud Gamal on 1/7/21.
 */
abstract class BaseFragment<T : BaseViewModel> : Fragment() {


    val viewModel: T by lazy { createViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(getLayoutRes(), container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupData()
        setupViews()
        setupObservers()
        if (savedInstanceState == null) // we fetch data only when the page is not recreated
            fetchData()
    }

    abstract fun getLayoutRes(): Int

    abstract fun createViewModel(): T

    /**
     * this method is a callback used to initialize your view
     * and called after @link #setupData()
     */
    protected open fun setupViews() {}

    /**
     * this method is a callback used to setup your data
     * and called after @link #getLayoutRes()
     */
    protected open fun setupData() {}


    /**
     * this method is a callback used to setup your observers
     * and called after @link #setupViews()
     */
    protected open fun setupObservers() {}

    /**
     * this method is a callback used to fetching data
     * and called after @link #setupObservers()
     * this callback will be called automatic when you first load the fragment
     */
    protected open fun fetchData() {}

}