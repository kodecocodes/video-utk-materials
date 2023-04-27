/*
* Copyright (c) 2023 Razeware LLC
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
*
* Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
* distribute, sublicense, create a derivative work, and/or sell copies of the
* Software in any work that is designed, intended, or marketed for pedagogical or
* instructional purposes related to programming, coding, application development,
* or information technology.  Permission for such use, copying, modification,
* merger, publication, distribution, sublicensing, creation of derivative works,
* or sale is expressly withheld.
*
* This project and source code may use libraries or frameworks that are
* released under various Open-Source licenses. Use of those libraries and
* frameworks are governed by their own individual licenses.
*
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
*/

package com.kodeco.android.dogbreedsapp.presentation.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.kodeco.android.dogbreedsapp.R
import com.kodeco.android.dogbreedsapp.domain.model.Breed

@Composable
fun BreedComponent(breed: Breed) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(200.dp)
  ) {
    AsyncImage(
      model = ImageRequest.Builder(LocalContext.current)
        .data(breed.imageUrl)
        .crossfade(true)
        .build(),
      placeholder = painterResource(R.drawable.ic_launcher_foreground),
      contentDescription = "Breed Image",
      contentScale = ContentScale.Crop,
      modifier = Modifier
        .clip(RoundedCornerShape(72.dp))
        .width(200.dp)
        .testTag("Dog's Image")
    )
    Spacer(modifier = Modifier.width(16.dp))
    Column(
      modifier = Modifier
        .fillMaxHeight()
        .testTag("Details Column"),
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = breed.name, style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 18.sp,
          fontWeight = FontWeight.SemiBold,
          color = Color.DarkGray
        ),
        modifier = Modifier.testTag("name")
      )
      Spacer(modifier = Modifier.height(7.dp))
      Text(
        text = breed.origin, style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 14.sp,
          fontWeight = FontWeight.Normal,
          color = Color.Gray
        )
      )
      Spacer(modifier = Modifier.height(7.dp))
      Text(
        text = breed.temperament,
        style = TextStyle(
          fontFamily = FontFamily.Monospace,
          fontSize = 14.sp,
          fontWeight = FontWeight.Normal,
          color = Color.Gray
        )
      )

    }
  }
}

@Preview
@Composable
fun BreedComponentPreview() {
  Surface(color = Color.White) {
    BreedComponent(
      breed = Breed(
        name = "ABC",
        origin = "Def",
        imageUrl = "https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg",
        temperament = "Melancholic"
      )
    )
  }

}