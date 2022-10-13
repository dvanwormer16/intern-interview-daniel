import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Tenant } from './tenant';
import { TenantService } from './tenant.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title(title: any) {
    throw new Error('Method not implemented.');
  }
  public tenants: Tenant[] = [];
  public editTenant: Tenant | undefined;
  public deleteTenant: Tenant | undefined;
  constructor(private tenantService: TenantService){}

  ngOnInit() {
    this.getTenants();
  }

  public searchTenants(key: string): void {
    const results: Tenant[] = [];
    for (const tenant of this.tenants) {
      if (tenant.name.toLowerCase().indexOf(key.toLowerCase()) != -1) {
        results.push(tenant);
      }
    }
    this.tenants = results;
    if (results.length == 0 || !key) {
      this.getTenants();
    }
  }

  public getTenants(): void {
    this.tenantService.getTenants().subscribe(
      (response: Tenant[]) => {this.tenants = response},
      (error: HttpErrorResponse) => {alert(error.message);});

  }

  public onAddTenant(addForm: NgForm): void {
    document.getElementById('add-tenant-form')?.click();
    this.tenantService.addTenant(addForm.value).subscribe(
      (response: Tenant) => {
        console.log(response);
        this.getTenants();
        response.assignCostOwed();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {alert(error.message);}
      );
  }

  public onUpdateTenant(tenant: Tenant): void {
    this.tenantService.updateTenant(tenant).subscribe(
      (response: Tenant) => {
        console.log(response);
        this.getTenants();
      },
      (error: HttpErrorResponse) => {alert(error.message);}
      );
  }

  public onDeleteTenant(tenantId: number): void {
    this.tenantService.deleteTenant(tenantId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTenants();
      },
      (error: HttpErrorResponse) => {alert(error.message);}
      );
  }


  public onOpenModal(tenant: Tenant, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode == 'add') {
      button.setAttribute('data-target', '#addTenantModal');
    }
    if (mode == 'edit') {
      this.editTenant = tenant;
      button.setAttribute('data-target', '#updateTenantModal');
    }
    if (mode == 'delete') {
      this.deleteTenant = tenant;
      button.setAttribute('data-target', '#deleteTenantModal');
    }
    container?.appendChild(button);
    button.click();
  }

  public onOpenAddModal(mode: string) {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode == 'add') {
      button.setAttribute('data-target', '#addTenantModal');
    }
    container?.appendChild(button);
    button.click();
  }

}
