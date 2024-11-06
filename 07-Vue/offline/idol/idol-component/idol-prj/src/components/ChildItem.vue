<script setup>
const props = defineProps(["name", "age"]);
console.log(props);
</script>

<template>
  <div>
    <h1>자식 컴포넌트1</h1>
    <h1>이름 : {{ name }}</h1>
    <h1>나이 : {{ age }}</h1>
  </div>
</template>

<style scoped></style>
