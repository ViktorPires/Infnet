<template>
  <div id="app">
    <h1>Questão 10 - TP1 - Frameworks</h1>
    <div>
      <h2>Lista de Tarefas</h2>
    </div>
      <div v-for="tarefa in tarefas" :key="tarefa.id">
        <p v-if="tarefa.estaCompleta" class="concluido">{{tarefa.id}} - {{tarefa.descricao}} - CONCLUÍDA</p>
        <p v-else class="pendente">{{tarefa.id}} - {{tarefa.descricao}} - PENDENTE</p>
      </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  data() {
    return {
      tarefas: [
          { id: 1, descricao: "Estudar Vue.js", estaCompleta: true},
          { id: 2, descricao: "Arrumar a cama", estaCompleta: false},
          { id: 3, descricao: "Passear com meu cachorrinho Bob", estaCompleta: false},
          { id: 4, descricao: "Realizar o TP1 de framework", estaCompleta: true},
          { id: 5, descricao: "Comprar um celular novo no shopping", estaCompleta: true},
          { id: 6, descricao: "Lavar a Louça", estaCompleta: false}
        ]
      }
    }
  }
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.concluido {
  color: green;
  text-decoration-line: line-through;
}

.pendente {
  color: red;
}
</style>
