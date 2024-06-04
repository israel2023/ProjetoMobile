package br.com.israelferreira.projetomobile.appfilmes.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import br.com.israelferreira.projetomobile.appfilmes.R
import br.com.israelferreira.projetomobile.appfilmes.model.Filme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaPrincipal(
    filmes: List<Filme>,
    onFilmeClick: (Filme) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "CastPrime")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.Yellow
                ),
                actions = {

                    Icon(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = null,
                        tint = Color.Yellow,
                        modifier = Modifier.size(32.dp)
                    )
                    /*IconButton(onClick = { /*Todo*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.logo),
                            contentDescription = null,
                            tint = Color.Yellow,
                            //modifier = Modifier.size(302.dp)
                        )

                    }*/
                }
            )
        }
    ){
        Column(modifier = Modifier
            .padding(it)
            .verticalScroll(rememberScrollState())){

            for(filme in filmes){
                FilmsCard(
                    filme = filme,
                    onClick = { onFilmeClick(filme) }
                )
            }
        }
    }
}

@Composable
fun FilmsCard(
    filme: Filme,
    onClick: (Filme) -> Unit
){
    Card(modifier = Modifier
        .clickable {
            onClick(filme)
        }
        .fillMaxWidth()
        .padding(6.dp)){
        Row(){
            Image(
                painter = painterResource(id = filme.capa),
                contentDescription = null,
                modifier = Modifier.height(120.dp),

            )
            Column(modifier = Modifier.padding(6.dp)){
                Text(
                    filme.titulo,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    filme.diretor,
                    maxLines = 1,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    filme.sinopse,
                    color = Color.Gray,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }

        }


    }
}

@Composable
@Preview
fun TelaPrincipalPreview(){
    TelaPrincipal(filmes = listOf(
        Filme(1, "Avengers: Endgame", "Peter Jackson", "Após Thanos eliminar metade das criaturas vivas, os Vingadores têm de lidar com a perda de amigos e entes queridos. Com Tony Stark vagando perdido no espaço sem água e comida, Steve Rogers e Natasha Romanov lideram a resistência contra o titã louco.", R.drawable.vingadores, "AÇÃO / AVENTURA"),
        Filme(2, "Joker", "Peter Jackson", "Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô. Sua ação inicia um movimento popular contra a elite de Gotham City, da qual Thomas Wayne é seu maior representante.",R.drawable.joker,"Ação"),
        Filme(3, "The Mummy", "Stanley Kubrick", "Na década de 1920, uma arqueóloga e seu irmão se unem a um aventureiro para encontrar um tesouro, mas acabam ressuscitando Imhotep, uma múmia diabólica e vingativa.", R.drawable.the_mummy, "Terror"),
        Filme(4, "Sidemen", "Peter Jackson", "Os Sidemen precisam enfrentar um novo vilão que nunca conheceram antes.", R.drawable.sidemen, "Aventura"),
        Filme(5, "The Batman", "Peter Jackson", "Após dois anos espreitando as ruas como Batman, Bruce Wayne se encontra nas profundezas mais sombrias de Gotham City. Com poucos aliados confiáveis, o vigilante solitário se estabelece como a personificação da vingança para a população.", R.drawable.the_batman, "Ação"),
        Filme(6, "Cruella", "Peter Jackson", "Inteligente, criativa e determinada, Estella quer fazer um nome para si através de seus designs e acaba chamando a atenção da Baronesa Von Hellman. Entretanto, o relacionamento delas desencadeia um curso de eventos e revelações que fazem com que Estella abrace seu lado rebelde e se torne a Cruella, uma pessoa má, elegante e voltada para a vingança.", R.drawable.cruella, "Comédia/Crime")

    ), onFilmeClick = { })
}