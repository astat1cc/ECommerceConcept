package com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.items

import com.github.astat1cc.sergeybalakintesttask.featuremainscreen.presentation.adapters.delegate_adapter.DelegateAdapterItem

data class SectionDelegateItem(
    val sectionTitle: String,
    val moreButtonText: String,
) : DelegateAdapterItem {

    override fun id(): Any = sectionTitle

    override fun content(): Any = SectionItemContent(sectionTitle, moreButtonText)

    inner class SectionItemContent(val sectionTitle: String, val moreButtonText: String) {
        override fun equals(other: Any?): Boolean {
            if (other is SectionDelegateItem) {
                return sectionTitle == other.sectionTitle && moreButtonText == other.moreButtonText
            }
            return false
        }

        override fun hashCode(): Int {
            var result = sectionTitle.hashCode()
            result = 31 * result + moreButtonText.hashCode()
            return result
        }
    }
}