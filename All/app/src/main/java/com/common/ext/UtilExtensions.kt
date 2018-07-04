package com.common.ext

import android.arch.lifecycle.*
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import org.reactivestreams.Publisher

fun <X, Y> LiveData<X>.switchMap(func: (X) -> LiveData<Y>)
        = Transformations.switchMap(this, func)

fun <X, Y> LiveData<X>.map  (func: (X) -> LiveData<Y>)
        = Transformations.map(this, func)

fun <T> Publisher<T>.toLiveData() = LiveDataReactiveStreams.fromPublisher(this)

fun <T> LiveData<T>.observe(owner: LifecycleOwner, observer: (T?) -> Unit) = observe(owner, object : Observer<T> {
    override fun onChanged(v: T?) {
        observer.invoke(v)
    }
})

@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(imageurl: String) {
    Picasso.with(this.context).load(imageurl).into(this)
}

fun isEmptyOrNull(value: Any?): Boolean = null == value || value == ""

fun isNotEmptyAndNull(value: Any?): Boolean = !isEmptyOrNull(value)