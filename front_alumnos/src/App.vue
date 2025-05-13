<script setup>
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

</style>
