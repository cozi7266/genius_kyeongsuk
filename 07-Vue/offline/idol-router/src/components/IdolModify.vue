<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRoute, useRouter } from "vue-router";

const idol = ref({ name: "", gender: "" });
const route = useRoute();
const router = useRouter();

const requestIdol = async () => {
  const { data: idolData } = await axios.get(
    `http://192.168.210.40:8080/api/idol/${route.query.no}`
  );
  idol.value = idolData;
};

const updateIdol = async () => {
    await axios.put(`http://192.168.210.40:8080/api/idol/${route.query.no}`, idol.value);
    router.push("/idollist");
};



requestIdol();
</script>

<template>
  <div id="update">
    <h2>아이돌 정보 수정</h2>
    <form @submit.prevent="updateIdol">
      <p>이름 : <input type="text" v-model="idol.name" /></p>
      <p>성별 : <input type="text" v-model="idol.gender" /></p>
      <button type="submit">수정</button>
      <button type="button" @click="requestIdolList">목록</button>
    </form>
  </div>
</template>

<style scoped>

</style>
