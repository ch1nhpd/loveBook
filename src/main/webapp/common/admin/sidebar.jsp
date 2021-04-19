<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <!-- Sidebar -->
    <ul class="sidebar navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/quan-tri/tran-chu">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Quản lí</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Sách</h6>
          <a class="dropdown-item" href="/quan-tri/sach/chinh-sua?id=">Thêm mới</a>
          <a class="dropdown-item" href="/quan-tri/sach/danh-sach">Danh sách</a>
          <a class="dropdown-item" href="#">chưa nghĩ ra :))</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Người dùng</h6>
          <a class="dropdown-item" href="/quan-tri/nguoi-dung/danh-sach">Danh sách </a>
          <a class="dropdown-item" href="/quan-tri/nguoi-dung/chinh-sua?id=">Thêm mới</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="fas fa-fw fa-chart-area"></i>
          <span>Charts</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">
          <i class="fas fa-fw fa-table"></i>
          <span>Tables</span></a>
      </li>
    </ul>