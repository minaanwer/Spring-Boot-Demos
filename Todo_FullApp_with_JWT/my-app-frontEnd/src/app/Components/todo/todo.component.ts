import { Component, OnInit } from '@angular/core';
import { TodoDataService } from 'src/app/Services/DataService/todo-data.service';
import { Todo } from '../list-todos/list-todos.component';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  constructor(
    private todoService: TodoDataService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  id: number
  todo: Todo = new Todo(0,'',true, new Date)

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id']
    if( this.id != -1 )
      this.RetriveToDo()
  }

  RetriveToDo() {

    this.todoService.RetriveTodo("monna", this.id).subscribe(
      response => {
        this.todo = response,
          console.log("when  RetriveToDo response is ")
        console.log(response)
      },
      error => console.log("error while RetriveToDo " + error)
    )
    console.log("Retrive todo  on page load .")
  }

  saveBtnClicked() {
    console.log("save btn clicked :")

    if( this.id == -1){
          this.todo.targetDate = new Date()
          this.todo.done = true
                  
      this.todoService.AddTodo(this.todo, "monna").subscribe(
        response => {
          console.log("success response")
          console.log(response)
          this.router.navigate(['todos'])
        },
        error => {
          console.log("error while try to add :")
          console.log(error)
          this.router.navigate(['todos'])
        }
      )
    }else{

      this.todoService.UpdateTodo(this.todo, "monna", this.id).subscribe(
        response => {
          console.log("success response")
          console.log(response)
          this.router.navigate(['todos'])
        },
        error => {
          console.log("error")
          console.log(error)
          this.router.navigate(['todos'])
        }
      )

    }
    
  }


}
