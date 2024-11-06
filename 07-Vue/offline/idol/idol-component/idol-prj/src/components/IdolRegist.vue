<template>
  <div id="register">
    <form @submit="registIdol">
      <p>이름 : <input type="text" v-model="idol.name" /></p>
      <p>성별 : <input type="text" v-model="idol.gender" /></p>
      <button>등록</button>
      <button @click="requestIdolList">목록</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
const emit = defineEmits(["listView"]);

const idol = ref({});

const registIdol = async () => {
  await axios.post("http://192.168.210.40:8080/api/idol", idol.value);
  requestIdolList(); // 성공 후 목록을 다시 불러옴
};

const requestIdolList = () => {
  emit("listView");
};
</script>

<style scoped></style>
