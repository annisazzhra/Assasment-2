package org.d3if3042.assasment2.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.d3if3042.assasment2.R
import org.d3if3042.assasment2.model.Tugas
import org.d3if3042.assasment2.ui.theme.Assasment2Theme

const val KEY_ID_TUGAS = "idTugas"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id: Long? = null) {
    val viewModel: DetailViewModel = viewModel()

    var judul by remember { mutableStateOf("") }
    var deskripsi by remember { mutableStateOf("") }
    var tanggalJatuhTempo by remember { mutableStateOf("") }
    var statusSelesai by remember { mutableStateOf(false) }

    if (id != null) {
        val data = viewModel.getTugas(id)
        judul = data.judul
        deskripsi = data.deskripsi
        tanggalJatuhTempo = data.tanggalJatuhTempo
        statusSelesai = data.statusSelesai
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.kembali),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                title = {
                    if (id == null)
                        Text(text = stringResource(id = R.string.tambah_tugas))
                    else
                        Text(text = stringResource(id = R.string.edit_tugas))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                actions = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Outlined.Check,
                            contentDescription = stringResource(R.string.simpan),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { padding ->
        FormTugas(
            judul = judul,
            onJudulChange = { judul = it },
            deskripsi = deskripsi,
            onDeskripsiChange = { deskripsi = it },
            tanggalJatuhTempo = tanggalJatuhTempo,
            onTanggalJatuhTempoChange = { tanggalJatuhTempo = it },
            statusSelesai = statusSelesai,
            onStatusSelesaiChange = { statusSelesai = it },
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FormTugas(
    judul: String, onJudulChange: (String) -> Unit,
    deskripsi: String, onDeskripsiChange: (String) -> Unit,
    tanggalJatuhTempo: String, onTanggalJatuhTempoChange: (String) -> Unit,
    statusSelesai: Boolean, onStatusSelesaiChange: (Boolean) -> Unit,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = judul,
            onValueChange = { onJudulChange(it) },
            label = { Text(text = stringResource(R.string.judul)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = deskripsi,
            onValueChange = { onDeskripsiChange(it) },
            label = { Text(text = stringResource(R.string.deskripsi)) },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            modifier = Modifier.fillMaxSize()
        )
        OutlinedTextField(
            value = tanggalJatuhTempo,
            onValueChange = { onTanggalJatuhTempoChange(it) },
            label = { Text(text = stringResource(R.string.tanggal_jatuh_tempo)) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        // Checkbox for status completion
        // Misalnya:
        // Checkbox(
        //     checked = statusSelesai,
        //     onCheckedChange = { onStatusSelesaiChange(it) },
        //     modifier = Modifier.fillMaxWidth()
        // ) {
        //     Text(text = stringResource(id = R.string.status_selesai))
        // }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DetailScreenPreview() {
    Assasment2Theme {
        DetailScreen(rememberNavController())
    }
}
