new Vue ({
    el:'#app',
    data: {
        currentTodo: "",
        todos: [
            {text: "Estudando Vue", done: false},
            {text: "Estudando mais Vue", done: false},
            {text: "Estudando react pra caramba", done: true}

        ]
    },
    methods: {
        addTodo() {
            this.todos.push ({
                text: this.currentTodo,
                done: false
            });
            this.currentTodo = "";
        },
        toggleTodo(todo) {
            todo.done = !todo.done;
        }
    }
});