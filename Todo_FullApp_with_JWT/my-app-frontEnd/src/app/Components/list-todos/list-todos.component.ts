import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../../Services/DataService/todo-data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})

export class ListTodosComponent implements OnInit {
  todos = []
  htmlmsg: string
  htmlSuccessmsg: string

  constructor(private todoDataService: TodoDataService, private router: Router) { }

  ngOnInit(): void {
    this.getTodosLst()
  }

  getTodosLst() {

    var result = this.todoDataService.RetriveAllToDos("monna")

    result.subscribe(
      responce => this.todos = responce,
      error => {
        this.htmlmsg = "Failed to Load Todo's ."
        console.log("error while  getTodosLst : " + error)
      }
    );

  }

  deleteBtnClicked(id) {

    console.log("btn Remove clicked  with Id   : " + id)
    var result = this.todoDataService.DeleteTodo("monna", id)
    result.subscribe(
      responce => {
        console.log("responce  :  " + responce)
        this.htmlSuccessmsg = "item deleted successfully ."
        this.getTodosLst()
      },
      error => {
        // this.htmlmsg = "Can not Delete item  ."
        // console.log("error  delete Btn Clicked :  " + error.message)

        this.htmlSuccessmsg = "Item with Id : " + id + " deleted successfully ."
        this.getTodosLst()
      }
    );


  }

  updateBtnClicked(id) {
    console.log("updateBtnClicked with id " + id)
    this.router.navigate(['todo', id])
  }

  addBtnClicked() {
    console.log("btn add new clicked")
    
    this.router.navigate(['todo',-1])

  }
  

}


//--------------------------------------------------------------------------------------
export class Todo {
  constructor(public id: number, public description: string, public done: boolean, public targetDate: Date) { }
}
