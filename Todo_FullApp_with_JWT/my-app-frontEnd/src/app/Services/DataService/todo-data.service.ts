import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Todo } from 'src/app/Components/list-todos/list-todos.component';
import { API_URL } from 'src/app/app.constants';


@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(
    private http: HttpClient
  ) { }


  RetriveAllToDos(userName) {
    return this.http.get<Todo[]>( API_URL + "/api/v1/todos/" + userName);
  }

  DeleteTodo(userName, id) {

    return this.http.delete( API_URL + "/api/v1/users/" + userName + "/todos/" + id);

  }

  RetriveTodo(username, id) {
    return this.http.get<Todo>(API_URL + "/api/v1/users/" + username + "/todo/" + id);
  }

  UpdateTodo(todo, username, id) {
    return this.http.put( API_URL + "/api/v1/users/" + username + "/todo/" + id, todo);
  }

  AddTodo(todo, username) {
    return this.http.post( API_URL + "/api/v1/users/" + username + "/todo", todo);
  }





}
