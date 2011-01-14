window.addEventListener("load", function() {
   var canvas, context, painting;
   
   function init() {
      canvas = document.getElementById("paintingCanvas");
      if (canvas == null) return;
      
      context = canvas.getContext("2d");
      if (context == null) return;
   
      painting = false;
      
      context.strokeStyle = "#00f";
      context.lineWidth = 3;
      context.font = "15px Helvetica";
   }

   init();
   
   canvas.addEventListener("mousedown", function(ev) {
      painting = true;
      context.beginPath();
      context.moveTo(ev.clientX-canvas.offsetLeft, ev.clientY-canvas.offsetTop);
   }, false);
   
   canvas.addEventListener("mousemove", function(ev) {
      updateReadout(ev.offsetX, ev.offsetY);

      if (painting) {
        paint(ev.offsetX, ev.offsetY);
      }
      function updateReadout(x, y) {
         context.clearRect(0, 0, 100, 20);
         context.fillText("x: " + x + ",  y: " + y, 5, 15);
      }
      function paint(x, y) {
         context.lineTo(ev.offsetX, ev.offsetY);
         context.stroke();
      }
         
   }, false);
   
   canvas.addEventListener("mouseup", function() {
      painting = false;
      context.closePath();
   }, false);
   
   
 }, false);