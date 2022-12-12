<template>
  <div class="" id="app">
    <div class="container grid-xs py-3">
      <img class="img-responsive img-logo" src="@/assets/logo.png" alt="logo">
      <form @submit.prevent="addTodo">
        <div class="input-group">
          <input type="text" v-model="todo.options.checked" class="form-input" placeholder="novo">
          {{ todo }}
          <button class="btn btn-primary input-g">Incluir TODO</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script> 
export default {
  name: 'App',
  data() {
    return {
      todos: [], todo: {options: {}}
    };
  },
methods: {
  addTodo() {
    console.log(this.todo)
  }
}};
</script>


