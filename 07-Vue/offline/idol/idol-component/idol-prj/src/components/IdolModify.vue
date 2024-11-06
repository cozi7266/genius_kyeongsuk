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

const props = defineProps(["no"]);

const requestIdol = async () => {
  const { data: idolData } = await axios.get(
    `http://192.168.210.40:8080/api/idol/${props.no}`
  );
  idol.value = idolData;
};

const registIdol = async () => {
  await axios.put(`http://192.168.210.40:8080/api/idol/${props.no}`, idol.value);
  requestIdolList();
};

const requestIdolList = () => {
  emit("listView");
};

requestIdol();
</script>

<style scoped></style>
