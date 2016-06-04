# Ecomuseu Guide (Guia Ecomuseu)

Projeto Android para o Ecomuseu (Foz do Iguaçu - PR - Brasil), para auxiliar os visitantes. O aplicativo irá conter diversas informações sobre os espaços e exposições do museu.

<b>Dentre as funcionalidades do aplicativo, estão:</b>
- Mapa iterativo (HTML, SVG, CSS, JavaScript) usando WebView do Android para fácil acesso as exposiçoes dos ambientes
  - Divisão do mapa em areas
    - Ultima localização acessada do usuário <i>(Em vermelho #ff7e7e)</i>
    - Areas da administração (Ex.: Auditorio, Manuntenção) <i>(Em roxo #c8c8ff)</i>
    - Areas acessiveis porem sem exposições (Ex.: Banheiros) <i>(Em azul #d8fdff)</i>
    - Areas acessiveis com exposições (Todas as demais areas) <i>(Em amarelo #fffcd8)</i>
    - Calçadas <i>(Em cinza #e8e8e8)</i>
    - Demais areas (Ex.: Grama) <i>(Em verde #9bd78e)</i>
  - Ao abrir o mapa ele localiza a ultima localização acessada no mesmo
  - Zoom in e Zoom out
  - Possivel acessar lista de exposições ao clicar sobre uma area acessivel com exposição (Amarela)
  - Legenda das areas na parte superior
- Lista de areas do museu, para acesso manual, caso não queira pelo mapa
- Leitor de QR Code (zxing-android-embedded, baseado no ZXing Barcode Scanner do Google) para rapido acesso a exposição (cada exposição do museu terá um QR Code)
- Conquistas para cada area que o usuario visitar (para desbloquear a conquista, somente por leitura de algum QR Code da area)
- Opção multi-linguagem (Atualmente en-rUS e pt-rBR)
- Opção de compartilhar que esteve no museu e a porcentagem de conquistas que adquiriu
