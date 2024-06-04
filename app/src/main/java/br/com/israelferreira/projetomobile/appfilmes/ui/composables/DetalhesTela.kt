package br.com.israelferreira.projetomobile.appfilmes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.israelferreira.projetomobile.appfilmes.R
import br.com.israelferreira.projetomobile.appfilmes.model.Filme

@Composable
fun DetalhesTela(filme: Filme?) {
    filme?.let {



        Row(modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .padding(5.dp)) {
            // Adiciona a capa do filme à esquerda
            Image(
                painter = painterResource(id = it.capa),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp) // ajuste a largura conforme necessário
            )

            Spacer(modifier = Modifier.width(16.dp))


            Column(modifier = Modifier

                .fillMaxWidth()) {
                Text(
                    text = it.titulo,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White

                )
                Text(
                    text = "Diretor: ${it.diretor}",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
                Text(
                    text = "Sinopse: ${it.sinopse}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White
                )
                /*RichText(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Markdown(content = it.sinopse)
                }*/
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetalhesTelaPreview() {
    DetalhesTela(carregarFilmes()[2])
}

fun carregarFilmes(): List<Filme> {
    return listOf(
        Filme(1, "Avengers: Endgame", "Peter Jackson", "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.", R.drawable.vingadores, "AÇÃO / AVENTURA"),
        Filme(2, "Joker", "Peter Jackson", "Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô. Sua ação inicia um movimento popular contra a elite de Gotham City, da qual Thomas Wayne é seu maior representante.",R.drawable.joker,"Ação"),
        Filme(3, "The Mummy", "Stanley Kubrick", "Na década de 1920, uma arqueóloga e seu irmão se unem a um aventureiro para encontrar um tesouro, mas acabam ressuscitando Imhotep, uma múmia diabólica e vingativa.", R.drawable.the_mummy, "Terror"),
        Filme(4, "Sidemen", "Peter Jackson", "Os Sidemen precisam enfrentar um novo vilão que nunca conheceram antes.", R.drawable.sidemen, "Aventura"),
        Filme(5, "The Batman", "Peter Jackson", "Após dois anos espreitando as ruas como Batman, Bruce Wayne se encontra nas profundezas mais sombrias de Gotham City. Com poucos aliados confiáveis, o vigilante solitário se estabelece como a personificação da vingança para a população.", R.drawable.the_batman, "Ação"),
        Filme(6, "Cruella", "Peter Jackson", "Inteligente, criativa e determinada, Estella quer fazer um nome para si através de seus designs e acaba chamando a atenção da Baronesa Von Hellman. Entretanto, o relacionamento delas desencadeia um curso de eventos e revelações que fazem com que Estella abrace seu lado rebelde e se torne a Cruella, uma pessoa má, elegante e voltada para a vingança.", R.drawable.cruella, "Comédia/Crime")
    )
}

