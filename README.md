# Guia Ecomuseu (Ecomuseu Guide)

Projeto Android para o Ecomuseu (Foz do Iguaçu - PR - Brasil), para auxiliar os visitantes. O aplicativo irá conter diversas informações sobre os espaços e exposições do museu.

<b>As funcionalidades do aplicativo são:</b>
- Mapa iterativo (HTML, SVG, CSS, JavaScript) usando WebView do Android para fácil acesso as exposiçoes das areas
	- Divisão do mapa em areas
		- Ultima localização acessada<i>(Em vermelho #ff7e7e)</i>
		- Areas da administração (Ex.: Auditorio, Manuntenção) <i>(Em roxo #c8c8ff)</i>
		- Areas acessiveis sem exposições (Ex.: Banheiros) <i>(Em azul #d8fdff)</i>
		- Areas acessiveis com exposições (Todas as demais areas) <i>(Em amarelo #fffcd8)</i>
		- Calçadas <i>(Em cinza #e8e8e8)</i>
		- Demais areas (Ex.: Grama) <i>(Em verde #9bd78e)</i>
	- Ao abrir o mapa ele localiza a ultima localização acessada
	- Zoom in e Zoom out
	- Possivel acessar lista de exposições ao clicar sobre uma area acessivel com exposição (Amarela)
	- Legenda das areas na parte superior
- Lista de areas do museu, para acesso manual, caso não queira pelo mapa
- Leitor de QR Code ([zxing-android-embedded](https://github.com/journeyapps/zxing-android-embedded), baseado no [ZXing Barcode Scanner do Google](https://github.com/zxing/zxing)) para rapido acesso a exposição (cada exposição do museu terá um QR Code)
- Conquistas para cada area que o usuario visitar (para desbloquear a conquista, somente por leitura de algum QR Code da area)
- Opção multi-linguagem (Atualmente en-rUS e pt-rBR)
- Opção de compartilhar que você esteve no museu e a porcentagem de conquistas que adquiriu

<b>Task List:</b>
- Geral
    - [ ] Inserir imagens finais nos assets
    - [ ] Inserir audios finais nos assets (en-rUS, pt-rBR, es-rAR)
    - [ ] Popular banco de dados com informações finais (en-rUS, pt-rBR, es-rAR)
    - [x] Quando abrir AchievementsFragment pela primeira vez falar como se conquista elas
    - Refinar layout do aplicativo (corrigir pequenos detalhes)
    	- [x] Achievements Fragment
		- [x] Exposition Fragment
		- [x] Exposition List Fragment
		- [x] Map Fragment (FloatingActionButton na esquerda que abre popup da legenda)
		- [x] Nome da sala na fragment da exposição
		- [x] Quando não existe imagem no banco de dados, mostrar somente texto, ao invés de imagem "No Image"
		- [x] Quando abrir mapa, mostrar todo ele e dar zoom do centro para a sala atual (Trocado por abrir direto na sala)
		- [x] Não girar tela, no ExpositionFragment
		- [x] No ExpositionFragment, usar imagem grande (ViewPager ou AndroidImageSlider, com marcadores) quando tiver mais de uma imagem.
		- [x] Adicionar fragment AboutFragment, com informações sobre o aplicativo
- Código
    - [x] Melhorar mais ainda o desemepenho do generateThumbnail()
    - [x] Tamanho da Heap fica crescendo enquanto rolo a Listview
    - [x] Dar close() em alguns objetos de conexão com o banco de dados (Alguns estão sem)
    - [x] Trocar o título da ActionBar ao trocar idioma do aplicativo
    - [x] Implementar pinch zoom, no ViewPager das imagens da exposição (com [TouchImageView](https://github.com/MikeOrtiz/TouchImageView))
    - [x] Trocar item selecionado do menu no drawer ao trocar fragment com link externo

	
-----------------------------


Android project for the Ecomuseum (Foz do Iguassu - PR - Brazil), to help visitors. The application will contain several information about the spaces and museum exhibitions.

<b>Application features are:</b>
- Iterative Map (HTML, SVG, CSS, JavaScript) using Android's WebView for easy access to the exhibitions of the areas
	- Map Division into areas
		- Last accessed location<i>(in red #ff7e7e)</i>
		- Administration areas (Ex .: Auditorium, Maintenance) <i>(in purple #c8c8ff)</i>
		- Accessible areas without exhibitions (Ex .: Bath) <i>(in blue #d8fdff)</i>
		- Accessible areas with exhibitions (All other areas) <i>(in yellow #fffcd8)</i>
		- Pavements <i>(in gray #e8e8e8)</i>
		- Other areas (Ex .: Grass) <i>(in green #9bd78e)</i>
	- When you open the map it finds the last location accessed
	- Zoom in and Zoom out
	- Possible access the exhibitions list by clicking on an accessible area with exhibitions (Yellow)
	- Labels of the areas at the top
- Museum areas list for manual access if you do not want the map
- QR Code Reader ([zxing-android-embedded](https://github.com/journeyapps/zxing-android-embedded), based on [ZXing Barcode Scanner from Google](https://github.com/zxing/zxing)) for quick access to exhibition (each museum exhibition will have a QR Code)
- Achievements for each area that the user visit (to unlock the achievement, only by reading a QR Code of area)
- Option multi-language (currently en-rUS and pt-rBR)
- Option to share you were in the museum and the percentage of achievements acquired

<b>Task List: </b>
- General
	- [ ] Insert final images in assets
	- [ ] Insert final audios in assets (en-rUS, pt-rBR, es-rAR)
	- [ ] Populate the database with final information (en-rUS, pt-rBR, es-rAR)
	- [x] When you open AchievementsFragment for the first time, show how to win them
	- Refine application layout (correct minor details)
		- [x] Achievements Fragment
		- [x] Exposition Fragment
		- [x] Exposition List Fragment
		- [x] Map Fragment (FloatingActionButton on the left opens map labels popup)
		- [x] Room name at the exposition fragment
		- [x] When there is no image in the database, display text only, instead of image "No Image"
		- [x] When open map, showing all of it and zoom from center to current room (Changed to open directly in room)
		- [x] Do not turn the screen in ExpositionFragment
		- [x] In ExpositionFragment, use large image (ViewPager or AndroidImageSlider, with markers) when you have more than one image.
		- [x] Add fragment AboutFragment, with informations about the application
- Code
	- [x] Improving further the performance of the generateThumbnail()
	- [x] Heap size increased while scrolling in the Listview
	- [x] Put close() in a few database objects (Some are without)
	- [x] Change the title of the ActionBar when change application language
	- [x] Implement pinch zoom, in ViewPager of exhibition images (with [TouchImageView](https://github.com/MikeOrtiz/TouchImageView))
	- [x] Change seletected item in drawer menu when change fragment with external link


-----------------------------


<b>ScreenShots</b>

<img width="80" src="http://i.imgur.com/7XWV7sG.jpg" alt="Menu" title="Menu">
<img width="80" src="http://i.imgur.com/OTK06ai.jpg" alt="Room List" title="Room List">
<img width="80" src="http://i.imgur.com/1m5K1HW.jpg" alt="Map" title="Map - Labels closed">
<img width="80" src="http://i.imgur.com/Gfx4jqy.jpg" alt="Map" title="Map - Labels opened">
<img width="80" src="http://i.imgur.com/Tkc6hHN.jpg" alt="Achievements" title="Achievements">
<img width="80" src="http://i.imgur.com/0aTfM5l.jpg" alt="Exposition" title="Exposition">
<img width="80" src="http://i.imgur.com/Ecc8w4n.jpg" alt="Options" title="Options">
<img width="80" src="http://i.imgur.com/q0L01zL.jpg" alt="Expositions List" title="Exposition List">
<img width="80" src="http://i.imgur.com/3mdk3GH.jpg" alt="Empty Expositions List" title="Empty Exposition List">
<img width="80" src="http://i.imgur.com/WkFFAHi.jpg" alt="QR Code Reader" title="QR Code Reader">


-----------------------------

<a href="https://drive.google.com/file/d/0B2IuetJD-2RwZkhmVXdLd1ByM0E/view?usp=sharing"><b>Download última versão / last version</b></a>
