import axios from "axios";
import React, { useEffect } from "react";
import { useState } from "react";
import styled from "styled-components";
import Header from "../components/Header";
import LayoutContainer from "../components/LayoutContainer";
import PageContainer from "../components/PageContainer";
import Sidebar from "../components/Sidebar";
import UserHeader from "../components/user/UserHeader";
import UserCard from "../components/user/UserCard";
import useScrollTop from "../util/useScrollTop";
import Pagination from "../components/Pagination";

const UsersBox = styled.div`
  padding: 24px;
`;

const UserBoxGrid = styled.ul`
  display: grid;
  grid-template-columns: repeat(4, minmax(0, 1fr));
  grid-gap: 20px;
  width: 100%;
  @media screen and (max-width: 1345px) {
    grid-template-columns: repeat(3, minmax(0, 1fr));
  }
  @media screen and (max-width: 1028px) {
    grid-template-columns: repeat(2, minmax(0, 1fr));
  }
  @media screen and (max-width: 711px) {
    grid-template-columns: repeat(1, minmax(0, 1fr));
  }
`;

export default function Users() {
  useScrollTop();
  const [users, setUsers] = useState([]);
  console.log(users);
  // 페이지네이션
  const [limit, setLimit] = useState(36);
  const [page, setPage] = useState(1);
  const [sort, setSort] = useState("Reputation");
  const offset = (page - 1) * limit;

  // 정렬
  const [order, setOrder] = useState("desc");

  // Input의 입력값
  const [value, setValue] = useState("");

  // API data
  const data1 = async () => {
    try {
      const userList = await (
        await axios.get(
          `https://api.stackexchange.com/2.3/users?pagesize=100&order=${order}&sort=&site=stackoverflow`
        )
      ).data;
      setUsers(userList.items);
    } catch (error) {
      throw new Error(error);
    }
  };
  const data2 = async () => {
    try {
      const userList = await (
        await axios.get(
          `https://api.stackexchange.com/2.3/users?pagesize=100&order=desc&sort=${sort}&inname=${value}&site=stackoverflow`
        )
      ).data;
      setUsers(userList.items);
    } catch (error) {
      throw new Error(error);
    }
  };

  useEffect(() => {
    if (value === "") {
      data1();
    } else {
      data2();
    }
  }, [value, sort]);
  return (
    <>
      <Header />
      <Sidebar />
      <LayoutContainer>
        <PageContainer>
          <UsersBox>
            <UserHeader
              setSort={setSort}
              sort={sort}
              setOrder={setOrder}
              setValue={setValue}
              value={value}
            />
            <UserBoxGrid>
              {users.slice(offset, offset + limit).map((user, idx) => (
                <UserCard
                  key={user.account_id}
                  profile={user.profile_image}
                  link={user.link}
                  name={user.display_name}
                  reputation={user.reputation}
                  gold={user.badge_counts.gold}
                  silver={user.badge_counts.silver}
                  bronze={user.badge_counts.bronze}
                  location={user.location}
                />
              ))}
            </UserBoxGrid>
            <Pagination
              total={users.length}
              limit={limit}
              page={page}
              setPage={setPage}
              setLimit={setLimit}
              disable
            />
          </UsersBox>
        </PageContainer>
      </LayoutContainer>
    </>
  );
}
