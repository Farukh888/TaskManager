package com.example.taskmanager.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.taskmanager.databinding.ItemOnboardingBinding
import com.example.taskmanager.ui.model.OnBoarding


class OnBoardingAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    val data = arrayListOf(
        OnBoarding(
            "https://pngimg.com/uploads/yandex/yandex_PNG16.png",
            "Найдётся всё",
            "www.yandex.ru"
        ),
        OnBoarding(
            "https://303421.selcdn.ru/soel-upload/iblock/6f9/6f9a9122dd27f1d68577fc8bbc4f5867/sberbank.png",
            "Всегда рядом",
            "www.sberbank.ru"
        ),
        OnBoarding(
            "https://cdn-images.hashtap.com/1200x600/img/3G/Bfq/ZFwr/ythDvYiTwpkEW/Csa2xYmu6g/KkKRQmi2gSWuMns6.jpg",
            "Банк новых возможностей",
            "www.alfabank.ru"
        ),

        )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {

            binding.btnStart.setOnClickListener {
                onClick()
            }

            binding.btnSkip.setOnClickListener {
                onClick()

            }

            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.btnSkip.isVisible = adapterPosition == data.lastIndex

            binding.tvTittle.text = onBoarding.tittle
            binding.tvDesc.text = onBoarding.desc
            /*/TODO:Bind image*/
            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)
        }
    }
}