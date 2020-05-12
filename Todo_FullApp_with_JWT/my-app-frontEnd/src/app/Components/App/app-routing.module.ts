import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { WelcomeComponent} from '../welcome/welcome.component';
import { ErrorComponent } from '../error/error.component';
import { ListTodosComponent } from '../list-todos/list-todos.component';
import { LogoutComponent } from '../logout/logout.component';
import { RouteGuardServiceService } from '../../Services/RouteGuardService/route-guard-service.service';
import { TodoComponent } from '../todo/todo.component';



const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'login' , component:LoginComponent },
  {path:'welcom/:name' , component:WelcomeComponent , canActivate:[RouteGuardServiceService] },
  {path:'todos',component:ListTodosComponent , canActivate:[RouteGuardServiceService] },
  {path:'logout',component:LogoutComponent , canActivate:[RouteGuardServiceService] },
  {path:'todo/:id',component:TodoComponent , canActivate:[RouteGuardServiceService] },

  {path :'**' , component:ErrorComponent  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes , {useHash : true} )],
  exports: [RouterModule]
})
export class AppRoutingModule { }