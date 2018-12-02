select * 
from 
	customers 
where
	customers.City = 'Irvine';
	
	
select * 
from
	orders o
inner join 
	employees e on o.EmployeeID = e.EmployeeID
where
	CONCAT(e.FirstName, ' ', e.LastName) = "Adam Barr";
	
	
select * 
from 
	orders o
inner join 
	order_details od on o.OrderID = od.OrderID
inner join 
	products p on od.ProductID = p.ProductID
inner join 
	customers c on o.CustomerID = c.CustomerID
where
	c.CompanyName = "Contoso, Ltd";
	
select *
from 
	orders o
inner join 
	shipping_methods s on o.ShippingMethodID = s.ShippingMethodID
where
	s.ShippingMethod = 'UPS Ground';
	
	
select 
	o.OrderID,
	sum(od.UnitPrice) as UnitPrice,
	sum(o.FreightCharge) as FreightCharge, 
	sum(od.UnitPrice) + sum(o.FreightCharge) as totalPrice,
	o.OrderDate 
from
	orders o
inner join 
	order_details od on o.OrderID = od.OrderID
group by 
	o.OrderID
order by 
	o.OrderDate desc;
