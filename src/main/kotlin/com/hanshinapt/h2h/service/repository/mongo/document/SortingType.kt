package com.hanshinapt.h2h.service.repository.mongo.document

/**
 * @author sangbeenmoon
 */
enum class SortingType() {
    MOST_LIKED, MOST_PLAYED;

    companion object {
        fun resolve(type: String): SortingType {
            return SortingType.valueOf(type.replace('-', '_').uppercase())
        }
    }

}
