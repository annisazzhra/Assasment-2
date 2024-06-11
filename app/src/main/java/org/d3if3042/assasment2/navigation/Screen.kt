package org.d3if3042.assasment2.navigation


sealed class Screen(val route: String) {
    object Home: Screen("mainScreen")
    object FormBaru: Screen("formBaru")
    object FormUbah: Screen("formUbah/{id}") {
        fun withId(id: Long) = "formUbah/$id"
    }
}
