package com.xiami.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiami.model.Goods;




@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//�����ݿ����id���в�ѯ
		//ֱ�Ӳ�������
		Goods goods = new Goods();
		goods.setId(id);
		goods.setName(id+"name");
		goods.setPrice(Double.parseDouble(id));
		goods.setCount(1);
		
		
		HttpSession session = request.getSession();
		List<Goods> goodsList = (List<Goods>)session.getAttribute("cart");
		if(goodsList == null){
			goodsList = new ArrayList<Goods>();
			goodsList.add(goods);
		}else{
			boolean flag = false;//Ĭ��δ�ҵ�
			for (Goods goods2 : goodsList) {
				if(goods2.equals(goods)){
					flag = true;
					goods2.setCount(goods2.getCount() + 1);
					break;
				}
				
			}
			
			if(!flag){
				goodsList.add(goods);
			}
			
		}
		session.setAttribute("cart", goodsList);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
