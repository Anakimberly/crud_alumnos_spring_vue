<script setup>
<<<<<<< HEAD
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div>
    <a href="https://vite.dev" target="_blank">
      <img src="/vite.svg" class="logo" alt="Vite logo" />
    </a>
    <a href="https://vuejs.org/" target="_blank">
      <img src="./assets/vue.svg" class="logo vue" alt="Vue logo" />
    </a>
  </div>
  <HelloWorld msg="Vite + Vue" />
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
=======
import {ref, onMounted} from 'vue';
import axios from 'axios';

const alumnos = ref([]);

const cargarAlumno = async (params) => {
  const response = await axios.get('localhost:8080/alumnos/traer-alumnos')
  alumnos.value = response.data;
  console.log(alumnos.value);
}

onMounted(cargarAlumno);
</script>

<template>
  <div class="container">
    <button class="btn btn-primary">Boton</button>
  </div>
  

</template>

<style scoped>

>>>>>>> 57796c5c59662769f3f03ed18fe06008d62120e9
</style>
