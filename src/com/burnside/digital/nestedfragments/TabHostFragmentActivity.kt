package com.burnside.digital.nestedfragments

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTabHost
import com.burnside.digital.nestedfragments.fragment.ParentViewPagerFragment
import com.burnside.digital.nestedfragments.fragment.SingleChildFragment


class TabHostFragmentActivity : AppCompatActivity() {

  override fun onCreate(state: Bundle?) {
    super.onCreate(state)

    supportActionBar?.apply {
      setTitle(R.string.activity_tabhost_title)
      setBackgroundDrawable(ColorDrawable(Color.rgb(13, 79, 72)))
      setDisplayHomeAsUpEnabled(true)
    }

    val tabs = FragmentTabHost(this)
    tabs.apply {
      setup(this@TabHostFragmentActivity, supportFragmentManager, R.layout.activity_nest_list)
      addTab(tabs.newTabSpec("ParentViewPagerFragment").setIndicator("View Pager"), ParentViewPagerFragment::class.java, null)
      addTab(tabs.newTabSpec("SingleFragment").setIndicator("Single Fragment"), SingleChildFragment::class.java, null)
    }

    setContentView(tabs)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean =
      when (item.itemId) {
        android.R.id.home -> onBackPressed().let { true }
        else -> super.onOptionsItemSelected(item)
      }
}
