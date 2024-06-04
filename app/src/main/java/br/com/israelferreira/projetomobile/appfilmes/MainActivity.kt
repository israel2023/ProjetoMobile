package br.com.israelferreira.projetomobile.appfilmes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import br.com.israelferreira.projetomobile.appfilmes.ui.theme.AppFilmesTheme
import br.com.israelferreira.projetomobile.appfilmes.model.Filme
import br.com.israelferreira.projetomobile.appfilmes.ui.composables.DetalhesTela
import br.com.israelferreira.projetomobile.appfilmes.ui.composables.TelaLogin
import br.com.israelferreira.projetomobile.appfilmes.ui.composables.TelaPrincipal

const val TELA_LOGIN = -1
const val TELA_PRINCIPAL = 0
const val TELA_DETALHES = 1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFilmesTheme {
                val filmes = carregarFilmes()

                var telaAtual by remember {
                    mutableIntStateOf(TELA_LOGIN)
                }

                var filmeAtual by remember {
                    mutableStateOf<Filme?>(null)
                }
                Log.d("MainActivity", "Tela inicial: $telaAtual")

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (telaAtual) {
                        TELA_LOGIN -> {
                            TelaLogin(onLogin = {
                                Log.d("MainActivity", "Login bem-sucedido")
                                telaAtual = TELA_PRINCIPAL
                            })
                        }

                        TELA_PRINCIPAL -> {
                            TelaPrincipal(
                                filmes = filmes,
                                onFilmeClick = { filme ->
                                    Log.d("MainActivity", "Filme clicado: ${filme.titulo}")
                                    filmeAtual = filme
                                    telaAtual = TELA_DETALHES
                                }
                            )
                        }

                        TELA_DETALHES -> {
                            filmeAtual?.let {
                                Log.d("MainActivity", "Exibindo detalhes do filme: ${it.titulo}")
                                DetalhesTela(filme = it)
                            } ?: run {
                                Log.e("MainActivity", "Filme atual é nulo")
                                telaAtual = TELA_PRINCIPAL
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun carregarFilmes(): List<Filme> {
    return listOf(
        Filme(1, "Avengers: Endgame", "Anthony and Joe Russo", "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.", R.drawable.vingadores, "AÇÃO / AVENTURA"),
        Filme(2, "Joker", "Todd Phillips", "Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô. Sua ação inicia um movimento popular contra a elite de Gotham City, da qual Thomas Wayne é seu maior representante.", R.drawable.joker, "Drama/Crime"),
        Filme(3, "The Mummy", "Stephen Sommers", "Na década de 1920, uma arqueóloga e seu irmão se unem a um aventureiro para encontrar um tesouro, mas acabam ressuscitando Imhotep, uma múmia diabólica e vingativa.", R.drawable.the_mummy, "Terror"),
        Filme(4, "Sidemen", "Peter Jackson", "Os Sidemen precisam enfrentar um novo vilão que nunca conheceram antes.", R.drawable.sidemen, "Aventura"),
        Filme(5, "The Batman", "Matt Reeves", "Após dois anos espreitando as ruas como Batman, Bruce Wayne se encontra nas profundezas mais sombrias de Gotham City. Com poucos aliados confiáveis, o vigilante solitário se estabelece como a personificação da vingança para a população.", R.drawable.the_batman, "Ação"),
        Filme(6, "Cruella", "Craig Gillespie", "Inteligente, criativa e determinada, Estella quer fazer um nome para si através de seus designs e acaba chamando a atenção da Baronesa Von Hellman. Entretanto, o relacionamento delas desencadeia um curso de eventos e revelações que fazem com que Estella abrace seu lado rebelde e se torne a Cruella, uma pessoa má, elegante e voltada para a vingança.", R.drawable.cruella, "Comédia/Crime")
    )
}
