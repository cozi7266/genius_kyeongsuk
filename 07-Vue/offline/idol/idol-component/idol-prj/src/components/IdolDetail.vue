<script setup>
import { ref } from "vue";
import axios from "axios";

const emit = defineEmits(["detailView", "listView", "modifyView"]);
const idol = ref(""); // idol 상태 정의

const props = defineProps(["no"]);

// 아이돌 정보 요청 함수
const requestIdol = async () => {
  const { data: idolData } = await axios.get(
    `http://192.168.210.40:8080/api/idol/${props.no}`
  );
  idol.value = idolData;
};

const requestIdolList = () => {
  emit("listView");
};

const deleteIdol = async (no) => {
  await axios.delete(`http://192.168.210.40:8080/api/idol/${no}`);
  requestIdolList();
};

const modifyIdolForm = async (no) => {
  emit("modifyView", no);
};

requestIdol();
</script>

<template>
  <div id="detail">
    <h2>상세</h2>
  </div>

  <div v-if="idol">
    <div id="detail">
      <p>번호 : {{ idol.no }}</p>
      <p>이름 : {{ idol.name }}</p>
      <p>성별 : {{ idol.gender }}</p>
      <button @click="modifyIdolForm(idol.no)">수정</button>
      <button @click="deleteIdol(idol.no)">삭제</button>
      <button @click="requestIdolList">목록</button>
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
</style>
