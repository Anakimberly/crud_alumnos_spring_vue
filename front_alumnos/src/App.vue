<script setup>
import { ref, onMounted } from 'vue';
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
    <h2>Tabla de Alumnos</h2>
    <table class="table">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Nombre</th>
          <th scope="col">Apellidos</th>
          <th scope="col">Carrera</th>
          <th scope="col">Telefono</th>
          <th scope="col">Imagen</th>
          <th scope="col">Acciones</th>
        </tr>
      </thead>
      <tr v-for="alumno in alumnos" :key="alumno.id">
        <td>{{ alumno.id }}</td>
        <td>{{ alumno.nombre }}</td>
        <td>{{ alumno.apellidos }}</td>
        <td>{{ alumno.carrera }}</td>
        <td>{{ alumno.telefono }}</td>
        <td><img :src="alumno.imagen" alt="Imagen de Alumno" width="50"></td>
        <td><button class="btn btn-danger">Eliminar</button></td>
      </tr>
    </table>
  </div>


</template>

<style scoped></style>
