cleari()
clearOutput()
drawStage(black)

var speed = 7.0
val contVite1 = ArrayBuffer.empty[Picture]
val contVite2 = ArrayBuffer.empty[Picture]
val cb = canvasBounds
var vel3 = Vector2D(1.0, 1.0)
var vel2 = Vector2D(3.5, 3.5)
var vel1 = Vector2D(0.2, 0.2)
var vel = Vector2D(1.5, 1.5)
var punteggio1 = 25
var punteggio2 = 20
var gioco = true

timer(1200) {
  vel += Vector2D(0.2, 0.2)
  vel2 += Vector2D(0.2, 0.2)
  vel3 += Vector2D(0.2, 0.2)
  speed += 0.1
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

def pGialla = {
  fillColor(yellow) -> Picture {
    setPenColor(yellow)
    right(14)
    repeat(3) {
      forward(15)
      left(120)
    }
  }
}

val ostacoli = HashSet.empty[Picture]
val ostacoli1 = HashSet.empty[Picture]
val ostacoli2 = HashSet.empty[Picture]
val ostacoli3 = HashSet.empty[Picture]
val ostacoli4 = HashSet.empty[Picture]
val ostacoli5 = HashSet.empty[Picture]
val ostacoli6 = HashSet.empty[Picture]
val cura = HashSet.empty[Picture]
val sfondo = HashSet.empty[Picture]

timer(16600) {
  val ven = Picture.image("venere.png")
  ven.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 15)
  ven.setHeading(225)
  sfondo.add(ven)
  draw(ven)
}

timer(25000) {
  val sat = Picture.image("saturno.png")
  sat.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 90)
  sat.setHeading(225)
  sfondo.add(sat)
  draw(sat)
}

timer(1600) {
  val ste = Picture.image("stelline.png")
  ste.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 6)
  ste.setHeading(225)
  sfondo.add(ste)
  draw(ste)
}

timer(19000) {
  val gal = Picture.image("galassia.png")
  gal.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) + 130)
  gal.setHeading(225)
  sfondo.add(gal)
  draw(gal)
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
  r.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 6)
  r.setHeading(225)
  ostacoli.add(r)
  draw(r)
}

timer(1600) {
  val a = pArancia
  a.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 9)
  a.setHeading(225)
  ostacoli1.add(a)
  draw(a)
}

timer(13000) {
  val v = pVerde
  v.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 9)
  v.setHeading(225)
  cura.add(v)
  draw(v)
}

timer(10000) {
  val b = pBlu
  b.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 9)
  b.setHeading(225)
  ostacoli2.add(b)
  draw(b)
}

timer(random(7400, 7500)) {
  var p = random(0, 2)
  if (p == 0) {
    val v1 = pViola
    v1.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 9)
    v1.setHeading(225)
    ostacoli3.add(v1)
    draw(v1)  
  }
  if (p == 1) {
    val v2 = pViola
    v2.setPosition(random(-(cb.width).toInt / 2, (cb.width).toInt / 2), ((cb.height).toInt / 2) - 9)
    v2.setHeading(225)
    ostacoli4.add(v2)
    draw(v2)
  }
}

timer(1) {
  nPunti1.update(punteggio1)
  nPunti2.update(punteggio2)
}
if (punteggio1 >= 30) {
  timer(1900) {
    val gi1 = pGialla
    gi1.setPosition(0, random(6, cb.height.toInt/2))
    gi1.setHeading(45)
    ostacoli5.add(gi1)
    draw(gi1)
  }
}

if (punteggio2 >= 30) {
  timer(1900) {
    val gi1 = pGialla
    gi1.setPosition(0, random(6, cb.height.toInt/2))
    gi1.setHeading(45)
    ostacoli5.add(gi1)
    draw(gi1)
  }
}

if (punteggio1 >= 30) {
  timer(1900) {
    val gi2 = pGialla
    gi2.setHeading(135)
    gi2.setPosition(cb.width.toInt/2, random(0, cb.height.toInt/2))
    ostacoli6.add(gi2)
    draw(gi2)
  }
}

if (punteggio2 >= 30) {
  timer(1900) {
    val gi2 = pGialla
    gi2.setHeading(135)
    gi2.setPosition(cb.width.toInt/2, random(0, cb.height.toInt/2))
    ostacoli6.add(gi2)
    draw(gi2)    
  }
}

val razzo1 = Picture.image("G1.png")
val g1 = Picture {  
  setPenColor(green)
  write("G1")
}
val giocatore1 = picColCentered(razzo1, g1)
giocatore1.setPosition(-125, -25)
draw(giocatore1)

val razzo2 = Picture.image("G2.png")
val g2 = Picture {
  setPenColor(green)
  write("G2")
}
val giocatore2 = picColCentered(razzo2, g2)
giocatore2.setPosition(125, -25)
draw(giocatore2)

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

var nVite = 3
var cuor1Pos = 0
var cuor2Pos = 0

def addVita1() {
  val cuor1 = cuore
  cuor1.setPosition(cb.x + 30 + cuor1Pos * 30, cb.y + cb.height - 30)
  cuor1.draw()
  contVite1.append(cuor1)
  cuor1Pos += 1
}

repeat(nVite) {
  addVita1
}

def addVita2() {
  val cuor2 = cuore
  cuor2.setPosition(cb.x + cb.width - 30 - cuor2Pos * 30, cb.y + cb.height - 30)
  cuor2.draw()
  contVite2.append(cuor2)
  cuor2Pos += 1
}

repeat(nVite) {
  addVita2
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

timer(2000) {
  punteggio1 = punteggio1+ 1
  nPunti1.update(punteggio1)
}

val nPunti1 = Picture.textu(punteggio1, 30)
nPunti1.translate(cb.x + 40, cb.y + cb.height - 50)
nPunti1.setPenColor(yellow)
draw(nPunti1)

timer(2000) {
  punteggio2 = punteggio2 + 1
  nPunti2.update(punteggio2)
}

val nPunti2 = Picture.textu(punteggio2, 30)
nPunti2.translate(cb.x + cb.width - 60, cb.y + cb.height - 50)
nPunti2.setPenColor(yellow)
draw(nPunti2)

def gameOver(msG1: String, msG2: String) {
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
  
  val scrittaFinale = picColCentered(scrittaPerdente, scrittaVincitore)
  drawCentered(scrittaFinale)
  stopAnimation()
}

activateCanvas()

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

  ostacoli5.foreach { gi1 =>
    gi1.translate(vel2*2)
  }

  ostacoli6.foreach { gi2 =>
    gi2.translate(vel2*2)
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

  sfondo.foreach { gal =>
    gal.translate(vel1)
    if(gal.collidesWith(stageBot)) {
      sfondo.remove(gal)
      gal.erase
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

  ostacoli5.foreach { gi1 =>
    if (gi1.collidesWith(stageRight)) {
      ostacoli5.remove(gi1)
      gi1.erase()
    }

    if (gi1.collidesWith(giocatore1)) {
      ostacoli5.remove(gi1)
      gi1.erase()
      aggiornaVite1(0)
    }

    if (gi1.collidesWith(giocatore2)) {
      ostacoli5.remove(gi1)
      gi1.erase()
      aggiornaVite2(0)
    }
  }

  ostacoli6.foreach { gi2 =>
    if (gi2.collidesWith(stageRight)) {
      ostacoli6.remove(gi2)
      gi2.erase()
    }

    if (gi2.collidesWith(giocatore1)) {
      ostacoli6.remove(gi2)
      gi2.erase()
      aggiornaVite1(0)
    }

    if (gi2.collidesWith(giocatore2)) {
      ostacoli6.remove(gi2)
      gi2.erase()
      aggiornaVite2(0)
    }
  }
  
  if (cuor1Pos == 0) {
    gameOver("G2 ha vinto", "G1 ha perso") 
  }

  if (cuor2Pos == 0) {
    gameOver("G1 ha vinto", "G2 ha perso")
  }

  if (punteggio1 >= 60) {
    gameOver("G1 ha vinto", "G2 ha perso")
  }

  if (punteggio2 >= 60) {
    gameOver("G2 ha vinto", "G1 ha perso")
  }
}

print("Benvenuto/a in questo videogioco senza nome")
print("\n")
print("Lo scopo del gioco è di arrivare a un totale di 60 punti prima di morire")
print("\n")
print("Un razzo si muove con le freccette, l'altro utilizzando WASD")
print("\n")
print("Evita le palline rosse che ti faranno perdere una vita e i triangoli arancioni che te ne faranno perdere 2. I quadrati verdi ti aggiungeranno una vita, quelli blu aggiungeranno un valore compreso tra -5 e 15 al punteggio. Quelli viola invece hanno un effetto random: togliere una vita all'avversario o ingrandire il tuo razzo.")
print("\n")