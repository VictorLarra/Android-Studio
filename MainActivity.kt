

package com.example.primeraclase

import android.content.res.Configuration
import android.inputmethodservice.Keyboard.Row
import android.media.Image
import android.os.Bundle
import android.os.Message
import android.provider.Telephony.Sms.Conversations
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.FlowPreview
import androidx.compose.foundation.layout.column
import org.w3c.dom.Text //import mio
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widrh
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import java.lang.reflect.Modifier
import androidx.compose.foundation.border
import androidx.compose.material3.materialTheme
import androidx.compose.material3.Surface
import androidx.compose.foundation.lazy.Lazycolumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize


class  MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTutorialTheme {
                conversation(SampleData.conversationSample)

                /**
                 */
                object SampleData {
                    // Sample conversation data
                    val conversationSample = listOf(
                        Message(
                            "Lexi",
                            "Test...Test...Test..."
                        ),
                        Message(
                            "Lexi",
                            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
                        ),
                        Message(
                            "Lexi",
                            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
                        ),
                        Message(
                            "Lexi",
                            "Searching for alternatives to XML layouts..."
                        ),
                        Message(
                            "Lexi",
                            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
                        ),
                        Message(
                            "Lexi",
                            "It's available from API 21+ :)"
                        ),
                        Message(
                            "Lexi",
                            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
                        ),
                        Message(
                            "Lexi",
                            "Android Studio next version's name is Arctic Fox"
                        ),
                        Message(
                            "Lexi",
                            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
                        ),
                        Message(
                            "Lexi",
                            "I didn't know you can now run the emulator directly from Android Studio"
                        ),
                        Message(
                            "Lexi",
                            "Compose Previews are great to check quickly how a composable layout looks like"
                        ),
                        Message(
                            "Lexi",
                            "Previews are also interactive after enabling the experimental setting"
                        ),
                        Message(
                            "Lexi",
                            "Have you tried writing build.gradle with KTS?"
                        ),
                    )
                }
        }
    }
}
    }

data class message(val author: String, val body:String)


@Composable
fun MessageCard (msg: Message) {
    //agregar el padding alrededor del mensaje
    Row (modifier = Modifier.padding(all = 8.dp)) {

        Image(
            painter = painterResource(R.drawable.profile_picture),
            contentDescription = null,
            modifier = Modifier

        //tamaño de la imagen
            .size(40.dp)

        //imagen puesta en un circulo
            .clip(CircleShape)

            //color del borde
            .border(1.5.dp, MaterialTheme.colorScheme.Primary, CircleShape)
        )

        //agregar espacio horizontal concorde a la imagen y la columna
        Spacer(modifier = Modifier.width(8.dp))

        //registro si la variable se expande o no
        var isExpanded by remember { mutableStateof(false)}

        //surfaceColor se actualizara gradualmente de un color a otro
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        //alternamos la variable isExpanded cuando hacemos clic en esta columna
    column (modifier = Modifier.clickable { isExpanded = !isExpanded}) {
        Text(
            text = msg.author,
            color = MaterialTheme.colorScheme.secondary
            Style = MaterialTheme.typography.titleSmall
        )

        //agregar espacio vertical entre el autor y el mensaje de texto
        Spacer(modifier = Modifier.height(4.dp))

        Surface(
            Shape = MaterialTheme.shapes.medium,
            shadowElevation = 1.dp,
        //El color de la superficie cambiara gradualmente del color primario al de la superficie
        color = surfaceColor,
        //animateContentSize cambiara el tamaño de la superficie gradualmente
        modifier = Modifier.animateContentSize().padding(1.dp)
        ) {
        Text(
            text = msg.body,
            modifier = Modifier.padding(all = 4.dp),
            //Si el mensaje está expandido mostrmos el contenido
            //De lo contrario, solo mostramos la primera línea
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            style = MaterialTheme.typography.bodyMedium
        )
    }
   }
  }
}

@Preview(name = "Light Mode")
@Preview (
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Composable
fun Conversations (message: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun  PreviewConversation() {
    ComposeTutorialTheme {
        Conversation(SampleData.conversationSample)
    }
}

