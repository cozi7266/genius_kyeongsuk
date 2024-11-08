<template>
  <div id="register">
    <form @submit="registIdol">
      <p>이름 : <input type="text" v-model="idol.name" /></p>
      <p>성별 : <input type="text" v-model="idol.gender" /></p>
      <button type="button" @click="registIdol">등록</button>
      <button type="button" @click="requestIdolList">목록</button>
    </form>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const router = useRouter();
const idol = ref({});


const requestIdolList = () => {
  router.push("/idollist");
};

const registIdol = async () => {
  await axios.post("http://192.168.210.40:8080/api/idol", idol.value);
  router.push("/idollist");
};


</script>
<style scoped></style>
