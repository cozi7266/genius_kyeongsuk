<template>
    <div class="container">
        <h3>이름: {{ card.name }} </h3>
        <p>직함: {{ card.title }} </p>
        <button @click="deleteCardFunc(card)">명함 삭제</button>
    </div>
</template>

<script setup>

const props = defineProps(["card"])
const emits = defineEmits(["deleteCardEvent"]);

const deleteCardFunc = function(card){
    emits("deleteCardEvent", card)
}

</script>

<style scoped>
.container{
    background-color: rgb(235, 232, 232);
    padding: 30px;
    width: 600px;
    border: 0.5px solid ;
    margin:30px;
}
</style>