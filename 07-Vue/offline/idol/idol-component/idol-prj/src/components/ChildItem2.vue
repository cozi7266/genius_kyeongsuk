<script setup>
import { ref } from "vue";
const emit = defineEmits(['recvData'])
const msg = ref("");
const sendData = () => {
  console.log(msg.value);
  emit('recvData', msg.value);
};
</script>

<template>
  <div>
    <h1>자식 컴포넌트2</h1>
    <input type="text" v-model="msg" />
    <button @click="sendData">DataSend</button>
  </div>
</template>

<style scoped></style>
