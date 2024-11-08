<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";

const idols = ref([]); 
const router = useRouter();

const requestIdolList = async () => {
  const { data: idolList } = await axios.get(
    "http://192.168.210.40:8080/api/idol"
  );
  idols.value = idolList;
};

const moveToIdolRegistForm = function() {
  router.push("/idolregist");
}

const moveToIdolDetail = function(no) {
  router.push("/idoldetail?no=" + no);
}

requestIdolList();
</script>

<template>
  <div id="list">
    <button @click="moveToIdolRegistForm">등록</button>
    <div v-for="idol in idols" :key="idol.no" @click=" moveToIdolDetail(idol.no)">
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
