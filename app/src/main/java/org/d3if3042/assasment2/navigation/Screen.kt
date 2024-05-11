package org.d3if3042.assasment2.navigation

import org.d3if3042.assasment2.ui.screen.KEY_ID_TUGAS

sealed class Screen(val route: String) {
    object Home: Screen("mainScreen")
    object FormBaru: Screen("detailScreen")
    object FormUbah: Screen("detailScreen/{$KEY_ID_TUGAS}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}
