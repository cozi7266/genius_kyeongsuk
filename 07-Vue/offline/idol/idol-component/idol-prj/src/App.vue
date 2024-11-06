<script setup>
import { ref } from "vue";

import IdolIndex from "@/views/IdolIndex.vue";
// import ChildItem from "@/components/ChildItem.vue";
// import ChildItem2 from "./components/ChildItem2.vue";

// const refff = ref("REFFF");
// const msg = ref("");
// const recvData = (data) => {
//   msg.value = data;
// }

</script>

<template>
  <div>
    <h2>Welcome to the Idol World</h2>
  </div>

  <div>
    <IdolIndex></IdolIndex>
    <!-- 부모는 자식컴포넌트에게 데이터를 전달할 때는 속성(attribute)으로 전달한다. (props) -->
    <!-- <ChildItem name="홍길동" age="20" />
    <ChildItem name="동동동" age="33" />
    <ChildItem :name="refff" age="33" /> -->

    <!-- <ChildItem2 @recvData="recvData" />
    <h2>msg : {{ msg }}</h2> -->
  </div>
</template>

<style scoped></style>
