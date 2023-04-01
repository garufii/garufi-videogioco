cleari()
clearOutput()
drawStage(black)

//var, val, def

var speed = 7.0

val contVite1 = ArrayBuffer.empty[Picture]

val contVite2 = ArrayBuffer.empty[Picture]

val cb = canvasBounds

var vel3 = Vector2D(1.0, 1.0)

var vel2 = Vector2D(3.5, 3.5)

var vel1 = Vector2D(0.2, 0.2)

var vel = Vector2D(1.5, 1.5)

var punteggio1 = 0

var punteggio2 = 0

val ostacoli = HashSet.empty[Picture]

val ostacoli1 = HashSet.empty[Picture]

val ostacoli2 = HashSet.empty[Picture]

val ostacoli3 = HashSet.empty[Picture]

val ostacoli4 = HashSet.empty[Picture]

val cura = HashSet.empty[Picture]

val sfondo = HashSet.empty[Picture]

val nPunti1 = Picture.textu(punteggio1, 30)

val nPunti2 = Picture.textu(punteggio2, 30)

var nVite = 3

var cuor1Pos = 0

var cuor2Pos = 0

val buttonGiocoRazzi = Picture {
  setPenFontSize(50)
  setPenColor(yellow)
  write("GAME 1")
}

buttonGiocoRazzi.setPosition(-250, 20)

val buttonGioco2 = Picture {
  setPenFontSize(50)
  setPenColor(yellow)
  write("GAME 2")
}

buttonGioco2.setPosition(80, 20)

val buttonR1 = Picture {
  setPenFontSize(40)
  setPenColor(green)
  write("1 PLAYER")
}

buttonR1.setPosition(-275, 20)

val msgnp = Picture {
  setPenFontSize(20)
  setPenColor(blue)
  write("(NO POINTS)")
}

val buttonR2p = Picture {
  setPenFontSize(40)
  setPenColor(blue)
  write("2 PLAYERS")
}

val buttonR2 = picColCentered(msgnp, buttonR2p)

buttonR2.setPosition(150, -15)

val buttonWASD = Picture {
  setPenFontSize(40)
  setPenColor(yellow)
  write("WASD")
}

buttonWASD.setPosition(-250, 15)

val buttonArrows = Picture {
  setPenFontSize(40)
  setPenColor(yellow)
  write("Arrows")
}

buttonArrows.setPosition(150, 15)

val buttonStart = Picture {
  setPenFontSize(60)
  setPenColor(red)
  write("START")
}

val buttonMenu = Picture {
  setPenFontSize(40)
  setPenColor(yellow)
  write("BACK TO MENU")
}

buttonMenu.setPosition(-150, -160)

val razzo1 = Picture.image("G1.png")

val g1 = Picture {  
  setPenColor(green)
  write("G1")
}

val giocatore1 = picColCentered(razzo1, g1)
giocatore1.setPosition(-125, -25)

val razzo2 = Picture.image("G2.png")

val g2 = Picture {
  setPenColor(green)
  write("G2")
}

val giocatore2 = picColCentered(razzo2, g2)
giocatore2.setPosition(125, -25)

def cuore = {
  fillColor(red) -> Picture {
    left(45)
    forward(15)
    repeat(4) {
      right(45)
      forward(5)
    }
    left(90)
    forward(5)
    repeat(3) {
      right(45)
      forward(5)
    }
    right(45)
    forward(15)
  }
}

def addVita1() {
  val cuor1 = cuore
  cuor1.setPosition(cb.x + 30 + cuor1Pos * 30, cb.y + cb.height - 30)
  cuor1.draw()
  contVite1.append(cuor1)
  cuor1Pos += 1
}

def addVita2() {
  val cuor2 = cuore
  cuor2.setPosition(cb.x + cb.width - 30 - cuor2Pos * 30, cb.y + cb.height - 30)
  cuor2.draw()
  contVite2.append(cuor2)
  cuor2Pos += 1
}

def aggiornaVite1(vite: Int) {
  if(vite==1){
    addVita1()
  }
  else if(vite==0){
    cuor1Pos -= 1
    contVite1(cuor1Pos).erase()
    var tmp = cuor1Pos
    while(tmp < contVite1.length) {
      contVite1(tmp).erase()
      tmp+=1
    }
  }
}

def aggiornaVite2(vite: Int) {
  if(vite==1){
    addVita2()
  }
  else if(vite==0){
    cuor2Pos -= 1
    contVite2(cuor2Pos).erase()
    var tmp = cuor2Pos
    while(tmp < contVite2.length) {
      contVite2(tmp).erase()
      tmp+=1
    }
  }
}

def gameOver1(msgVinto: String, msgPerso: String) {
  val scrittaHaiVinto = Picture {
    setPenFontSize(80)
    setPenColor(green)
    write(msgVinto)
  }
  
  val scrittaHaiPerso = Picture {
    setPenFontSize(80)
    setPenColor(red)
    write(msgPerso)
  }

  val scrittaFinale1 = picStackCentered(scrittaHaiVinto, scrittaHaiPerso)

  val scrittaHaiFatto = Picture {
    setPenFontSize(50)
    setPenColor(yellow)
    write("YOUR SCORE IS ")
  }
  
  val scrittaTot = Picture {
    setPenFontSize(50)
    setPenColor(yellow)
    write(punteggio1)
    }

  val scrittaConteggio = picRowCentered(scrittaHaiFatto, scrittaTot)
  
  val scrittaFinalissima = picColCentered(scrittaConteggio, scrittaFinale1)
  drawCentered(scrittaFinalissima)
  stopAnimation()
  nPunti1.erase()
  draw(buttonMenu)
  }


def gameOver2(msG1: String, msG2: String) {
  val scrittaVincitore = Picture {
    setPenFontSize(80)
    setPenColor(green)
    write(msG1)
  }

  val scrittaPerdente = Picture {
    setPenFontSize(80)
    setPenColor(red)
    write(msG2)
  }
  
  val scrittaFinale2 = picColCentered(scrittaPerdente, scrittaVincitore)
  drawCentered(scrittaFinale2)
  stopAnimation()
  nPunti1.erase()
  nPunti2.erase()
  draw(buttonMenu)
}

def pRossa = {
  fillColor(red) -> Picture.circle(6)
}

def pArancia = {
  fillColor(cm.rgb(255, 120, 20)) -> Picture {
    setPenColor(cm.rgb(255, 120, 20))
    right(14)
    repeat(3) {
      forward(15)
      left(120)
    }
  }
}

def pVerde = {
  fillColor(green) -> Picture {
    setPenColor(green)
    repeat(4) {
      forward(8)
      left(90) 
    }
  }
}

def pBlu = {
  fillColor(blue) -> Picture {
    setPenColor(blue)
    repeat(4) {
      forward(8)
      left(90)
    }
  }
}

def pViola = {
  fillColor(magenta) -> Picture {
    setPenColor(magenta)
    repeat(4) {
      forward(8)
      left(90)
    }
  }
}


drawCentered(buttonStart)

buttonStart.onMouseClick { (x, y) =>
  draw(buttonGiocoRazzi)
  draw(buttonGioco2)
  buttonStart.translate(0, 400)
}

buttonGiocoRazzi.onMouseClick { (x, y) =>
  draw(buttonR2)
  draw(buttonR1)
  buttonGiocoRazzi.erase
  buttonGioco2.erase
}

buttonGioco2.onMouseClick { (x, y) =>
  
}
  
buttonMenu.onMouseClick { (x, y) => 
  cleari()
  drawStage(black)
  def tmp = buttonStart
  drawCentered(tmp)
}

//2 players game


buttonR2.onMouseClick { (x, y) =>
  
  animate {

  if (isKeyPressed(Kc.VK_D)) {
    giocatore1.translate(speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_A)) {
    giocatore1.translate(-speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_W)) {
    giocatore1.translate(0, speed)
  }

  if (isKeyPressed(Kc.VK_S)) {
    giocatore1.translate(0, -speed)
  }
  
  if (isKeyPressed(Kc.VK_RIGHT)) {
    giocatore2.translate(speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_LEFT)) {
    giocatore2.translate(-speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_UP)) {
    giocatore2.translate(0, speed)
  }
  
  if (isKeyPressed(Kc.VK_DOWN)) {
    giocatore2.translate(0, -speed)
  }

  if (giocatore1.collidesWith(stageBot)) {
    giocatore1.translate(0, speed)
  }

  if (giocatore1.collidesWith(stageTop)) {
    giocatore1.translate(0, -speed)
  }  

  if (giocatore1.collidesWith(stageLeft)) {
    giocatore1.translate(speed, 0)
  }

  if (giocatore1.collidesWith(stageRight)) {
    giocatore1.translate(-speed, 0)
  }

  if (giocatore2.collidesWith(stageBot)) {
    giocatore2.translate(0, speed)
  }

  if (giocatore2.collidesWith(stageTop)) {
    giocatore2.translate(0, -speed)
  }  

  if (giocatore2.collidesWith(stageLeft)) {
    giocatore2.translate(speed, 0)
  }

  if (giocatore2.collidesWith(stageRight)) {
    giocatore2.translate(-speed, 0)
  }


  ostacoli.foreach { r =>
    r.translate(vel)
  }
  
  ostacoli1.foreach { a =>
    a.translate(vel2)
  }
  
  cura.foreach { v =>
    v.translate(vel3)
  }
  
  ostacoli2.foreach { b =>
    b.translate(vel3)
  }
  
  ostacoli3.foreach { v1 =>
    v1.translate(vel3)
  }
  
  ostacoli4.foreach { v2 =>
    v2.translate(vel3)
  }
  
  sfondo.foreach { sat =>
    sat.translate(vel1)
    if (sat.collidesWith(stageBot)) {
      sfondo.remove(sat)
      sat.erase
    }
  }
  
  sfondo.foreach { mar =>
    mar.translate(vel1)
    if (mar.collidesWith(stageBot)) {
      sfondo.remove(mar)
      mar.erase()
    }
  }
  
  sfondo.foreach { ste =>
    ste.translate(vel1)
    if (ste.collidesWith(stageBot)) {
      sfondo.remove(ste)
      ste.erase
    }
  }
  
  ostacoli.foreach { r =>
    if (r.collidesWith(stageBot)) {
      ostacoli.remove(r)
      r.erase()
    }

    if (r.collidesWith(giocatore1)) {
      ostacoli.remove(r)
      r.erase()
      aggiornaVite1(0)
    }

    if (r.collidesWith(giocatore2)) {
      ostacoli.remove(r)
      r.erase()
      aggiornaVite2(0)
    }
  }
  
  ostacoli1.foreach { a =>  
    if (a.collidesWith(stageBot)) {
      ostacoli1.remove(a)
      a.erase()
    }

    if (a.collidesWith(giocatore1)) {
      ostacoli1.remove(a)
      a.erase()
      if (cuor1Pos == 1) {
        aggiornaVite1(0)
      }
      else {
        aggiornaVite1(0)
        aggiornaVite1(0)
      }
    }
    if (a.collidesWith(giocatore2)) {
        ostacoli1.remove(a)
        a.erase()
      if (cuor2Pos == 1) {
        aggiornaVite2(0)
      }
      else {
        aggiornaVite2(0)
        aggiornaVite2(0)
      }
    }
  }
  
  cura.foreach { v =>
    if (v.collidesWith(stageBot)) {
      cura.remove(v)
      v.erase()
    }

    if (v.collidesWith(giocatore1)) {
      cura.remove(v)
      v.erase()
      aggiornaVite1(1)
    }

    if (v.collidesWith(giocatore2)) {
      cura.remove(v)
      v.erase()
      aggiornaVite2(1)
    }
  }
  
  ostacoli2.foreach { b =>
    if (b.collidesWith(stageBot)) {
      ostacoli2.remove(b)
      b.erase()
    }

    if (b.collidesWith(giocatore1)) {
      ostacoli2.remove(b)
      b.erase()
      punteggio1 += random(-5, 15)
      nPunti1.update(punteggio1)
    }

    if (b.collidesWith(giocatore2)) {
      ostacoli2.remove(b)
      b.erase()
      punteggio2 += random(-5, 15)
      nPunti2.update(punteggio2)
    }
  }
  
  ostacoli3.foreach { v1 =>
    if (v1.collidesWith(stageBot)) {
      ostacoli3.remove(v1)
      v1.erase()
    }

    if (v1.collidesWith(giocatore1)) {
      ostacoli3.remove(v1)
      v1.erase()
      aggiornaVite2(0)
    }
    
    if (v1.collidesWith(giocatore2)) {
      ostacoli3.remove(v1)
      v1.erase()
      aggiornaVite1(0)
    }
  }
    
  ostacoli4.foreach { v2 =>
    if (v2.collidesWith(stageBot)) {
      ostacoli4.remove(v2)
      v2.erase()
    }

    if (v2.collidesWith(giocatore1)) {
      ostacoli4.remove(v2)
      v2.erase()
      giocatore1.scale(1.1)
    }
    
    if (v2.collidesWith(giocatore2)) {
      ostacoli4.remove(v2)
      v2.erase()
      giocatore2.scale(1.1)
    }
  }
  
  if (cuor1Pos == 0) {
    gameOver2("G2 has won!", "G1 has lost :(") 
  }

  if (cuor2Pos == 0) {
    gameOver2("G1 has won!", "G2 has lost :(")
  }

  if (punteggio1 >= 50) {
    gameOver2("G1 has won!", "G2 has lost :(")
  }

  if (punteggio2 >= 50) {
    gameOver2("G2 has won!", "G1 has lost :(")
  }
  
}

timer(12000) {
  val ven = Picture.image("venere.png")
  ven.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 150)
  ven.setHeading(225)
  sfondo.add(ven)
  draw(ven)
}

timer(15000) {
  val sat = Picture.image("saturno.png")
  sat.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 230)
  sat.setHeading(225)
  sfondo.add(sat)
  draw(sat)
}

timer(1600) {
  val ste = Picture.image("stelline.png")
  ste.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  ste.setHeading(225)
  sfondo.add(ste)
  draw(ste)
}

timer(14400) {
  val mar = Picture.image("marte.png")
  mar.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 65)
  mar.setHeading(225)
  sfondo.add(mar)
  draw(mar)
}

timer(290) {
  val r = pRossa
  r.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  r.setHeading(225)
  ostacoli.add(r)
  draw(r)
}

timer(1600) {
  val a = pArancia
  a.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2 ), ((cb.height).toInt / 2) + 30)
  a.setHeading(225)
  ostacoli1.add(a)
  draw(a)
}

timer(13000) {
  val v = pVerde
  v.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  v.setHeading(225)
  cura.add(v)
  draw(v)
}

timer(10000) {
  val b = pBlu
  b.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  b.setHeading(225)
  ostacoli2.add(b)
  draw(b)
}

timer(random(7400, 7500)) {
  var p = random(0, 2)
  if (p == 0) {
    val v1 = pViola
    v1.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
    v1.setHeading(225)
    ostacoli3.add(v1)
    draw(v1)  
  }
  if (p == 1) {
    val v2 = pViola
    v2.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
    v2.setHeading(225)
    ostacoli4.add(v2)
    draw(v2)
  }
}

timer(1) {
  nPunti1.update(punteggio1)
  nPunti2.update(punteggio2)
}

nPunti1.translate(cb.x + 40, cb.y + cb.height - 50)
nPunti1.setPenColor(yellow)
draw(nPunti1)

nPunti2.translate(cb.x + cb.width - 60, cb.y + cb.height - 50)
nPunti2.setPenColor(yellow)
draw(nPunti2)

timer(2000) {  
  punteggio2 = punteggio2 + 1
  nPunti2.update(punteggio2)
}

timer(2000) {
  punteggio1 = punteggio1+ 1
  nPunti1.update(punteggio1)
}
timer(1200) {
  vel += Vector2D(0.2, 0.2)
  vel2 += Vector2D(0.2, 0.2)
  vel3 += Vector2D(0.2, 0.2)
  speed += 0.1
}

repeat(nVite) {
  addVita1
}

repeat(nVite) {
  addVita2
}

draw(giocatore1)
draw(giocatore2)
buttonR2.erase
buttonR1.erase
}

//1 player wasd game

buttonR1.onMouseClick { (x, y) =>
  draw(buttonWASD)
  draw(buttonArrows)
  buttonR1.erase
  buttonR2.erase
}

buttonWASD.onMouseClick { (x, y) =>
  
  animate {

  if (isKeyPressed(Kc.VK_D)) {
    giocatore1.translate(speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_A)) {
    giocatore1.translate(-speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_W)) {
    giocatore1.translate(0, speed)
  }

  if (isKeyPressed(Kc.VK_S)) {
    giocatore1.translate(0, -speed)
  }

  if (giocatore1.collidesWith(stageBot)) {
    giocatore1.translate(0, speed)
  }

  if (giocatore1.collidesWith(stageTop)) {
    giocatore1.translate(0, -speed)
  }  

  if (giocatore1.collidesWith(stageLeft)) {
    giocatore1.translate(speed, 0)
  }

  if (giocatore1.collidesWith(stageRight)) {
    giocatore1.translate(-speed, 0)
  }


  ostacoli.foreach { r =>
    r.translate(vel)
  }
  
  ostacoli1.foreach { a =>
    a.translate(vel2)
  }
  
  cura.foreach { v =>
    v.translate(vel3)
  }
  
  ostacoli2.foreach { b =>
    b.translate(vel3)
  }
  
  ostacoli3.foreach { v1 =>
    v1.translate(vel3)
  }
  
  ostacoli4.foreach { v2 =>
    v2.translate(vel3)
  }

  sfondo.foreach { sat =>
    sat.translate(vel1)
    if (sat.collidesWith(stageBot)) {
      sfondo.remove(sat)
      sat.erase
    }
  }
  
  sfondo.foreach { mar =>
    mar.translate(vel1)
    if (mar.collidesWith(stageBot)) {
      sfondo.remove(mar)
      mar.erase()
    }
  }
  
  sfondo.foreach { ste =>
    ste.translate(vel1)
    if (ste.collidesWith(stageBot)) {
      sfondo.remove(ste)
      ste.erase
    }
  }
  
  ostacoli.foreach { r =>
    if (r.collidesWith(stageBot)) {
      ostacoli.remove(r)
      r.erase()
    }

    if (r.collidesWith(giocatore1)) {
      ostacoli.remove(r)
      r.erase()
      aggiornaVite1(0)
    }
  }
  
  ostacoli1.foreach { a =>  
    if (a.collidesWith(stageBot)) {
      ostacoli1.remove(a)
      a.erase()
    }

    if (a.collidesWith(giocatore1)) {
      ostacoli1.remove(a)
      a.erase()
      if (cuor1Pos == 1) {
        aggiornaVite1(0)
      }
      else {
        aggiornaVite1(0)
        aggiornaVite1(0)
      }
    }
  }
    
  cura.foreach { v =>
    if (v.collidesWith(stageBot)) {
      cura.remove(v)
      v.erase()
    }

    if (v.collidesWith(giocatore1)) {
      cura.remove(v)
      v.erase()
      aggiornaVite1(1)
    }
  }
  
  ostacoli2.foreach { b =>
    if (b.collidesWith(stageBot)) {
      ostacoli2.remove(b)
      b.erase()
    }

    if (b.collidesWith(giocatore1)) {
      ostacoli2.remove(b)
      b.erase()
      punteggio1 += random(-5, 15)
      nPunti1.update(punteggio1)
    }
  }
  
  if (cuor1Pos == 0) {
    gameOver1("", "DEFEAT") 
  }

  if (punteggio1 >= 50) {
    gameOver1("WIN", "")
  }
}

timer(22000) {
  val ven = Picture.image("venere.png")
  ven.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 150)
  ven.setHeading(225)
  sfondo.add(ven)
  draw(ven)
}

timer(25000) {
  val sat = Picture.image("saturno.png")
  sat.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 230)
  sat.setHeading(225)
  sfondo.add(sat)
  draw(sat)
}

timer(1600) {
  val ste = Picture.image("stelline.png")
  ste.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  ste.setHeading(225)
  sfondo.add(ste)
  draw(ste)
}

timer(19000) {
  val mar = Picture.image("marte.png")
  mar.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 65)
  mar.setHeading(225)
  sfondo.add(mar)
  draw(mar)
}

timer(290) {
  val r = pRossa
  r.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  r.setHeading(225)
  ostacoli.add(r)
  draw(r)
}

timer(1600) {
  val a = pArancia
  a.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2 ), ((cb.height).toInt / 2) + 30)
  a.setHeading(225)
  ostacoli1.add(a)
  draw(a)
}

timer(13000) {
  val v = pVerde
  v.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  v.setHeading(225)
  cura.add(v)
  draw(v)
}

timer(10000) {
  val b = pBlu
  b.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  b.setHeading(225)
  ostacoli2.add(b)
  draw(b)
}

timer(1) {
  nPunti1.update(punteggio1)
}

nPunti1.translate(cb.x + 40, cb.y + cb.height - 50)
nPunti1.setPenColor(yellow)
draw(nPunti1)


timer(2000) {
  punteggio1 = punteggio1+ 1
  nPunti1.update(punteggio1)
}
timer(1200) {
  vel += Vector2D(0.2, 0.2)
  vel2 += Vector2D(0.2, 0.2)
  vel3 += Vector2D(0.2, 0.2)
  speed += 0.1
}

repeat(nVite) {
  addVita1
}

giocatore1.scale(1.25)
drawCentered(giocatore1)
buttonWASD.erase
buttonArrows.erase
}

//1 player arrows game

buttonArrows.onMouseClick { (x, y) =>
  
  animate {

  if (isKeyPressed(Kc.VK_RIGHT)) {
    giocatore1.translate(speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_LEFT)) {
    giocatore1.translate(-speed, 0)
  }
  
  if (isKeyPressed(Kc.VK_UP)) {
    giocatore1.translate(0, speed)
  }

  if (isKeyPressed(Kc.VK_DOWN)) {
    giocatore1.translate(0, -speed)
  }

  if (giocatore1.collidesWith(stageBot)) {
    giocatore1.translate(0, speed)
  }

  if (giocatore1.collidesWith(stageTop)) {
    giocatore1.translate(0, -speed)
  }  

  if (giocatore1.collidesWith(stageLeft)) {
    giocatore1.translate(speed, 0)
  }

  if (giocatore1.collidesWith(stageRight)) {
    giocatore1.translate(-speed, 0)
  }


  ostacoli.foreach { r =>
    r.translate(vel)
  }
  
  ostacoli1.foreach { a =>
    a.translate(vel2)
  }
  
  cura.foreach { v =>
    v.translate(vel3)
  }
  
  ostacoli2.foreach { b =>
    b.translate(vel3)
  }
  
  ostacoli3.foreach { v1 =>
    v1.translate(vel3)
  }
  
  ostacoli4.foreach { v2 =>
    v2.translate(vel3)
  }

  sfondo.foreach { sat =>
    sat.translate(vel1)
    if (sat.collidesWith(stageBot)) {
      sfondo.remove(sat)
      sat.erase
    }
  }
  
  sfondo.foreach { mar =>
    mar.translate(vel1)
    if (mar.collidesWith(stageBot)) {
      sfondo.remove(mar)
      mar.erase()
    }
  }
  
  sfondo.foreach { ste =>
    ste.translate(vel1)
    if (ste.collidesWith(stageBot)) {
      sfondo.remove(ste)
      ste.erase
    }
  }
  
  ostacoli.foreach { r =>
    if (r.collidesWith(stageBot)) {
      ostacoli.remove(r)
      r.erase()
    }

    if (r.collidesWith(giocatore1)) {
      ostacoli.remove(r)
      r.erase()
      aggiornaVite1(0)
    }
  }
  
  ostacoli1.foreach { a =>  
    if (a.collidesWith(stageBot)) {
      ostacoli1.remove(a)
      a.erase()
    }

    if (a.collidesWith(giocatore1)) {
      ostacoli1.remove(a)
      a.erase()
      if (cuor1Pos == 1) {
        aggiornaVite1(0)
      }
      else {
        aggiornaVite1(0)
        aggiornaVite1(0)
      }
    }
  }
    
  cura.foreach { v =>
    if (v.collidesWith(stageBot)) {
      cura.remove(v)
      v.erase()
    }

    if (v.collidesWith(giocatore1)) {
      cura.remove(v)
      v.erase()
      aggiornaVite1(1)
    }
  }
  
  ostacoli2.foreach { b =>
    if (b.collidesWith(stageBot)) {
      ostacoli2.remove(b)
      b.erase()
    }

    if (b.collidesWith(giocatore1)) {
      ostacoli2.remove(b)
      b.erase()
      punteggio1 += random(-5, 15)
      nPunti1.update(punteggio1)
    }
  }
  
  if (cuor1Pos == 0) {
    gameOver1("", "DEFEAT") 
  }

  if (punteggio1 >= 40) {
    gameOver1("WIN", "")
  }
}

timer(22000) {
  val ven = Picture.image("venere.png")
  ven.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 150)
  ven.setHeading(225)
  sfondo.add(ven)
  draw(ven)
}

timer(25000) {
  val sat = Picture.image("saturno.png")
  sat.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 230)
  sat.setHeading(225)
  sfondo.add(sat)
  draw(sat)
}

timer(1600) {
  val ste = Picture.image("stelline.png")
  ste.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  ste.setHeading(225)
  sfondo.add(ste)
  draw(ste)
}

timer(19000) {
  val mar = Picture.image("marte.png")
  mar.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 65)
  mar.setHeading(225)
  sfondo.add(mar)
  draw(mar)
}

timer(290) {
  val r = pRossa
  r.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  r.setHeading(225)
  ostacoli.add(r)
  draw(r)
}

timer(1600) {
  val a = pArancia
  a.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2 ), ((cb.height).toInt / 2) + 30)
  a.setHeading(225)
  ostacoli1.add(a)
  draw(a)
}

timer(13000) {
  val v = pVerde
  v.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  v.setHeading(225)
  cura.add(v)
  draw(v)
}

timer(10000) {
  val b = pBlu
  b.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 30)
  b.setHeading(225)
  ostacoli2.add(b)
  draw(b)
}

timer(1) {
  nPunti1.update(punteggio1)
}

nPunti1.translate(cb.x + 40, cb.y + cb.height - 50)
nPunti1.setPenColor(yellow)
draw(nPunti1)


timer(2000) {
  punteggio1 = punteggio1+ 1
  nPunti1.update(punteggio1)
}
timer(1200) {
  vel += Vector2D(0.2, 0.2)
  vel2 += Vector2D(0.2, 0.2)
  vel3 += Vector2D(0.2, 0.2)
  speed += 0.1
}

repeat(nVite) {
  addVita1
}

giocatore1.scale(1.25)
drawCentered(giocatore1)
buttonArrows.erase
buttonWASD.erase
}

println("il pulsante ''GAME 2'' non funziona ancora")

println("il pulsante ''BACK TO MENU'' non funziona ancora")

