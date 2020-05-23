package com.elifox.legocatalog.legotheme.data

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*


@Entity(tableName = "themes")
public data class LegoTheme(
        @PrimaryKey
        @field:SerializedName("id")
        val id: Int,
        @field:SerializedName("name")
        val name: String,
        @field:SerializedName("parent_id")
        val parentId: Int? = null
) {
    override fun toString() = name

    companion object {
        var DIFF_CALLBACK: DiffUtil.ItemCallback<LegoTheme> = object : DiffUtil.ItemCallback<LegoTheme>() {
            override fun areItemsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: LegoTheme, newItem: LegoTheme): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val lTheme: LegoTheme = other as LegoTheme
        return Objects.equals(id, lTheme.id) &&
                Objects.equals(name, lTheme.name) &&
                Objects.equals(parentId, lTheme.parentId)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}