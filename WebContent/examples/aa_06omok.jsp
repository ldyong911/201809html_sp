<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String pan = request.getParameter("pan");
%>

<html lang="en">
	<head>
		<title>three.js webgl - geometry - cube</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
		<style>
			body {
				margin: 0px;
				background-color: #ffffff;
				overflow: hidden;
			}
		</style>
		<script src="jquery-1.12.4.js"></script>
	</head>
	<body id="my_body" onload="fn_load()">
		<script src="../build/three.js"></script>
		<script src="js/controls/OrbitControls.js"></script>
		<script>
			var camera, scene, renderer;
			var mesh;
			
			var texture1, geometry1, material1;
			var texture2, geometry2, material2;
			var mesh1, mesh2;
			
			function fn_load(){
				init();
				animate();
				fn_ajax2();
			}

			function init() {
				camera = new THREE.PerspectiveCamera( 70, window.innerWidth / window.innerHeight, 1, 1000 );
				camera.position.z = 800;
				camera.rotation.z = Math.PI;

				scene = new THREE.Scene();

				var texture = new THREE.TextureLoader().load( 'textures/omok/pan.png' );
				var geometry = new THREE.PlaneBufferGeometry( 600, 600, 4, 4 );
				var material = new THREE.MeshBasicMaterial( { map: texture } );
				mesh = new THREE.Mesh(geometry, material);
				scene.add(mesh);
				
				texture1 = new THREE.TextureLoader().load( 'textures/omok/black.png' );
				geometry1 = new THREE.CylinderBufferGeometry( 25, 25, 5, 40, 40 );
				material1 = new THREE.MeshBasicMaterial( { map: texture1 } );
				
				texture2 = new THREE.TextureLoader().load( 'textures/omok/white.png' );
				geometry2 = new THREE.CylinderBufferGeometry( 25, 25, 5, 40, 40 );
				material2 = new THREE.MeshBasicMaterial( { map: texture2 } );
				
				mesh1 = new THREE.Mesh( geometry1, material1 );
				mesh1.rotation.x = Math.PI * 0.5;
				mesh1.position.z = 2.5;
				mesh1.position.x = -270;
				mesh1.position.y = 270;
				scene.add(mesh1);
				
				mesh2 = new THREE.Mesh( geometry2, material2 );
				mesh2.rotation.x = Math.PI * 0.5;
				mesh2.position.z = 2.5;
				mesh2.position.x = 270;
				mesh2.position.y = -270;
				scene.add(mesh2);

				renderer = new THREE.WebGLRenderer( { antialias: true } );
				renderer.setPixelRatio( window.devicePixelRatio );
				renderer.setSize( window.innerWidth, window.innerHeight );
				document.body.appendChild(renderer.domElement);

				//
				
				window.addEventListener( 'resize', onWindowResize, false );
				
				var orbit = new THREE.OrbitControls(camera, renderer.domElement); // 시점 변경
				orbit.update();
			}

			function onWindowResize() {
				camera.aspect = window.innerWidth / window.innerHeight;
				camera.updateProjectionMatrix();

				renderer.setSize( window.innerWidth, window.innerHeight );
			}
			
			var index_scene = 0;
			var index_omok = 0;
			
			function animate() {
// 				console.log(index_scene);
				index_scene++;
				
				requestAnimationFrame( animate );
				
				if(index_scene%100 == 0){
					fn_draw_onestone();
					index_omok++;
				}
				
// 				mesh.position.x += 1;
				
// 				mesh1.rotation.x += 0.005;
// 				mesh2.rotation.x += 0.005;

				renderer.render( scene, camera );
			}
			
			function fn_draw_onestone(){
				var str = arrHistory[index_omok];
				
				var ii = -1;
				var jj = -1;
				var int_status = -1;
				var int_temp = -1;
				
				if(index_omok == 0){
					for(var i=0; i<str.length; i++){
						var str_temp = str.substring(i, i+1);
						if(str_temp > 0){
							int_status = Number(str_temp);
							int_temp = i;
							break;
						}
					}
				}else if(index_omok < arrHistory.length){
					var str_pre = arrHistory[index_omok-1];
					for(var i=0; i<str.length; i++){
						var str_temp = str.substring(i, i+1);
						var str_temp_pre = str_pre.substring(i, i+1);
						if(str_temp != str_temp_pre){
							int_status = Number(str_temp);
							int_temp = i;
							break;
						}
					}
				}else{
					return;
				}
				
				
				ii = parseInt(int_temp / 10);
				jj = int_temp % 10;
				
				fn_add_stone(ii, jj, int_status);
			}
			
			var pan = <%=pan%>;
			var arrHistory = new Array();
			
			function fn_ajax2(){
				$.ajax({
					type : "get",
					url : "http://127.0.0.1/GAMESOCKET/mypan_jsonp",
					data : {pan: pan},
					dataType : "jsonp",
					jsonpCallback : "myCallback",

					success : function(data) {
						for(var i=0; i<data.length; i++){
							arrHistory.push(data[i].history);
						}
						
						console.log(arrHistory);
					},

					error : function(xhr, status, error) {
						console.log("에러!: " + error);
					},

				});
			}
			
			function fn_add_stone(ii, jj, int_status){
				var startX = -270;
				var startY = 270;
				var endX = 270;
				var endY = -270;
				var betweenX = (endX-startX)/(10-1);
				var betweenY = (endY-startY)/(10-1);
				
				var meshTemp;
				if(int_status == 1){
					meshTemp = new THREE.Mesh(geometry1, material1);
				}else if(int_status == 2){
					meshTemp = new THREE.Mesh(geometry2, material2);
				}
				
				meshTemp.rotation.x = Math.PI * 0.5;
				meshTemp.position.z = 2.5;
				meshTemp.position.x = startX+(jj*betweenX);
				meshTemp.position.y = startY+(ii*betweenY);
				scene.add(meshTemp);
			}

		</script>
		
		<a href="javascript:fn_add_stone()">더하기</a>
	</body>
</html>