<template>
  <div class="container">
    <header>
      <h1>명함 관리 페이지</h1>
    </header>
    <main>
      <p>명함을 관리하는 페이지입니다. 여기에 명함 목록이 표시됩니다.</p>
    </main>
    <article>
      <h2>보유 명함 목록</h2>
      <p v-if="count !== 0">현재 보유중인 명함 수 : {{ count }}</p>
      <p v-else>명함이 없습니다. 새로운 명함을 추가해 주세요.</p>
      <div class="card-list">
        <BusinessCard @send-count="updateCount" />
      </div>
    </article>
    <footer>
      <p>&copy; 2023 My Business Cards</p>
    </footer>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import BusinessCard from './components/BusinessCard.vue';


const count = ref(0);

const updateCount = (newCount) => {
  count.value = newCount;
};
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  text-align: center;
}

header {
  background-color: rgb(53, 123, 228);
  color: white;
  padding: 20px;
  max-width: 500px;
  margin: 0 auto;
}

main, article {
  margin: 20px;
}

.card-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
}

footer {
  background-color: rgb(230, 224, 224);
  font-size: 0.8em;
  color: gray;
  padding: 10px;
}
</style>
