package m17.sdk.demo.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.m17ent.core.module.sdk.interfaces.M17LiveCellBaseView
import m17.sdk.demo.R


class TestLiveCellLayout : FrameLayout, M17LiveCellBaseView {

    //private lateinit var binding : TestAdapterLiveListItemBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)
    constructor(context: Context, attrs: AttributeSet?) :
            this(context, attrs, 0)
    constructor(context: Context) :
            this(context, null)

    private var coverImageView: ImageView? = null
    private var nameTextView: TextView? = null

    init {
        //binding =  DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.test_adapter_live_list_item, this, true)

        LayoutInflater.from(context).inflate(R.layout.test_adapter_live_list_item, this, true)
        coverImageView = findViewById(R.id.coverImageView) as ImageView
        nameTextView = findViewById(R.id.nameTextView) as TextView
    }

    override fun getRenderCoverImgView(): ImageView {
        return coverImageView!!
        //return binding?.coverImageView
    }

    override fun getRenderNameTextView(): TextView {
        return nameTextView!!
        //return binding?.nameTextView
    }
}