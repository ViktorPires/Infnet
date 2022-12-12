<template>
  <img alt="Vue logo" src="./assets/logo.png">
 <!-- <button @click="increment">{{count}}</button> -->
 <p>Possui Atividade</p>
 <span>{{hasTodo}}</span>
</template>

<script>
//export default {
  //data() {
    //return {
      //count: 0
    //}
  //},
  //methods: {
   // increment() {
   //   this.count++
   // }
 // },
  //perda de referência do this -> Não Fazer
  //methods: {
  // increment: () => {
  //  } 
  //}
  //mounted() {
    //this.increment()
 // },
  //tempo de atualização do DOM utilizando API Global nextTick()
  //methods: {
    //increment () {
      //this.count++
      //nextTick(() => {

      //})
   // }
 // }
//}
//$
// _

// Propriedades Computadas

export default {
  data() {
    return {
      author: {},
      name: "Aluno",
      todo: [
        "atividade 1 - andar de bicicleta",
        "atividade 2 - estudar vue",
        "atividade 3 - estudar react"
      ] 
    }
  },
  computed: {
    hasTodo() {
      return this.author.todo.length > 0 ? 'tem atividade': 'não tem'
    }
  }
}
</script>
