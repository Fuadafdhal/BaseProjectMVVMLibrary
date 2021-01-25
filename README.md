<h1 align="center">
    BaseProjectMVVPPLibrary
</h1>

<p align="center">
    <a><img src="https://img.shields.io/badge/Version-1.0.1-brightgreen.svg?style=flat"></a>
    <a><img src="https://img.shields.io/badge/Koltin-Suport-green?logo=kotlin&style=flat"></a>
    <a href="https://github.com/Fuadafdhal"><img src="https://img.shields.io/github/followers/Fuadafdhal?label=follow&style=social"></a>
</p>

 ---
 ## Download
 Add maven `jitpack.io` and `dependencies` in build.gradle (Project) :
 ```gradle
 // build.gradle project
 allprojects {
   repositories {
      ...
      maven { url 'https://jitpack.io' }
   }
 }
 
 // build.gradle app/module
 dependencies {
     ...
     implementation 'com.github.Fuadafdhal:BaseProjectMVVMLibrary:1.0.1'
     implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
     implementation 'androidx.recyclerview:recyclerview:1.1.0'
 }
 ```

 ## Feature List
 - [x] **Simpel for make initial viewmodel for fragment and activity**.
 - [x] **Simpel for make initial viewmodel plus toolbar for fragment and activity**.

 ## Tech stack and 3rd library
 - ViewModel ([docs](https://developer.android.com/topic/libraries/architecture/viewmodel))
 - Recyclerview ([docs](https://developer.android.com/jetpack/androidx/releases/recyclerview))
 - Toolbar ([docs](https://developer.android.com/reference/android/widget/Toolbar))

 ---

 ## Use

 ### Viewmodel In Activity
 ```kotlin
 class MainActivity : BaseActivity<MainViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.struktur_activity)
        
	
        viewmodel.getdata()
        viewmodel.mData.observe(this, {
            
        })
                
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }
 }

 ```

 Here is the `viewmodel` generate from BaseActivity 


 ---

 ### Viewmodel In Fragment

 ```kotlin
 class MainFragment : BaseFragment<MainViewModel>() {
    
    ....	

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        	
        viewmodel.getdata()
        viewmodel.mData.observe(viewLifecycleOwner, {
            
        })
                
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }
 }

 ```

 Here is the `viewmodel` generate from BaseFragment 

 ---

 ### Viewmodel In Activity With Toolbar

 ```kotlin
 class MainActivity : BaseToolbarActivity<MainViewModel>() {
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        
	
        viewmodel.getdata()
        viewmodel.mData.observe(this, {
            
        })
                
    }

    override fun setToolbar(): Toolbar {
        return mBinding.appbarLayout.toolbar
    }
    
    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }
 }

 ```

 Here is the `viewmodel` generate from BaseToolbarActivity and `setToolbar` generate become to setSupportActionBar

 ---

 ### Viewmodel In Fragment With Toolbar


 ```kotlin
 class MainFragment : BaseToolbarFragment<MainViewModel>() {
    
    ....	

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        	
        viewmodel.getdata()
        viewmodel.mData.observe(viewLifecycleOwner, {
            
        })
                
    }
    
    override fun setToolbar(): Toolbar {
        return mBinding.appbarLayout.toolbar
    }

    override fun initViewModel(): MainViewModel {
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }
 }

 ```

 Here is the `viewmodel` generate from BaseToolbarFragment and `setToolbar` generate become to setSupportActionBar 
 
---

 ### Adapter Recyclerview
 ```kotlin
 // Recyclerview Adapter
 class MainAdapter : BaseRecyclerViewAdapter<MainAdapter.VHolder, News>() {
    inner class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mBinding = ItemNewsBinding.bind(itemView)

        init {
            mBinding.root.setOnClickListener {
                onItemClick?.invoke(items[adapterPosition])
            }
        }

        fun onBind(mNews: News) {
            mBinding.textTitleItem.text = mNews.title
            mBinding.textDateItem.text = mNews.timestamp
        }
    }

    override fun onBindViewHolder(holder: VHolder, item: News, position: Int) {
        holder.onBind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false))
    }
 }


 // in activity
 class MainActivity : BaseActivity<NewsVModel>() {
 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
	
	val mainAdapter = MainAdapter()
	
	newsAdapter.onItemClick = { selected ->
            Toast.makeText(this, selected.title, Toast.LENGTH_SHORT).show()
        }
	
	with(mBinding.rvNews) {
            setHasFixedSize(true)
            adapter = newsAdapter
        }
    }
 }

 ```

 ---
 
 ### Version
 - **1.0**
   - First Release

---

 ### Contribution
 You can sent your constibution to `branche` `open-pull`.

 ---

 ```
    Copyright 2021 Muh Fuad Afdhal

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 ```




