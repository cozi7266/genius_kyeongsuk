<script setup>
import { ref } from "vue";
import axios from "axios";
const emit = defineEmits(["detailView", "insertView"]);

const currentView = ref("list"); // 나중에 라우터로
const idols = ref([]); // 전체 아이돌 목록

const requestIdolList = async () => {
  const { data: idolList } = await axios.get(
    "http://192.168.210.40:8080/api/idol"
  );
  // console.dir(idolList);
  idols.value = idolList;
  currentView.value = "list";
};
requestIdolList();

const requestIdol = (no) => {
  emit("detailView", no);
};

const registIdolForm = () => {
  emit("insertView");
};
</script>

<template>
  <div id="list">
    <button @click="registIdolForm">등록</button>
    <div v-for="idol in idols" :key="idol.no" @click="requestIdol(idol.no)">
      <p>번호 : {{ idol.no }}</p>
      <p>이름 : {{ idol.name }}</p>
      <p>성별 : {{ idol.gender }}</p>
    </div>
  </div>
</template>

<style scoped>
#list div {
  border: 1px solid #535353;
  padding: 10px;
  margin: 5px;
  border-radius: 5px;
  background-color: #2f98d441;
  color: #333333;
}

#list div:hover {
  cursor: pointer;
  background-color: #328dc29a;
  color: #f9f9f9;
  /* box-shadow: 1px 1px 1px 1px #2c5c79; */
  transition: 1ms;
}
</style>
